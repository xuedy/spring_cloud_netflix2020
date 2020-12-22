package com.xue.example.common.utils;

/**
 * 雪花算法
 */
public class SnowFlakeGenerator {

    private long roomId; //机房id
    private long wokerId; //机器id
    private long roomIdBit = 5l; //占用5个bit位
    long wokerIdBit = 5l; //占用5个bit位
    //声明roomId最大的正整数 32
    private long maxRoomId = -1l ^ (-1l << roomIdBit);
    private long maxWokerId = -1l ^ (-1l << wokerIdBit);
    private long sequenceBits = 12l; //12bit的递增序列.
    private long sequence; //递增开始的序列

    public SnowFlakeGenerator(long roomId, long wokerId, long sequence) {
        if (wokerId > maxWokerId || wokerId < 0) {
            throw new IllegalArgumentException("woker Id 错误");
        }
        if (roomId > maxRoomId || roomId < 0) {
            throw new IllegalArgumentException("room Id 错误");
        }
        this.roomId = roomId;
        this.wokerId = wokerId;
        this.sequence = sequence;
    } //记录sequence能够存储的最大的长度

    private long sequenceMask = -1l ^ (-1l << sequenceBits);
    private long lastTimeStamp = -1L; //存储上一次生成的id的时间戳
    private long twepoch = 1596372483166L; //初始的时间值
    private long wokerIdShift = sequenceBits;
    // 美团leafsnowﬂake算法(改造->时钟回拨的问题) 数据库数据库的高可用（master-slave） 多主, （step）
    private long roomIdShift = sequenceBits + wokerIdBit;
    private long timeStampShift = sequenceBits + wokerIdBit + roomIdBit;

    public static void main(String[] args) throws InterruptedException {
        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator(1, 1, 1);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            System.out.println(snowFlakeGenerator.nextVal());
        }
    }

    public synchronized long nextVal() {
        //开始去生成ID
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimeStamp) {
            throw new RuntimeException("时间戳异常");
        }
        if (lastTimeStamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {

                //如果==0，表示sequence的值超过了4095.
                timestamp = waitToNextMills(lastTimeStamp);
            }
        } else {
            sequence = timestamp & 1; //如果进入到了新的时间毫秒，sequence从0开始
        }
        lastTimeStamp = timestamp;
        return ((timestamp - twepoch) << timeStampShift | (roomId << roomIdShift) | (wokerId << wokerIdShift) | sequence);
    } //执行到下一个时间毫秒

    private long waitToNextMills(long lastTimeStamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimeStamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}