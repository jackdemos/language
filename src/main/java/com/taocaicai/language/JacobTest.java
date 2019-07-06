package com.taocaicai.language;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.util.Random;

public class JacobTest {
    public static void main(String[] args) {
        ActiveXComponent ax = null;
        int customerNumber = 1;
        while (true) {
            try {
                Random random = new Random();
                int windowsNumber = random.nextInt(10);

                ax = new ActiveXComponent("Sapi.SpVoice");
                /**运行时输出语音内容*/
                Dispatch spVoice = ax.getObject();
                ax.setProperty("Volume", new Variant(100));
                /**语音朗读速度 -10 到 +10*/
                ax.setProperty("Rate", new Variant(-2));
                /**执行朗读*/
                Dispatch.call(spVoice, "Speak", new Variant("请" + customerNumber + "号到" + windowsNumber + "窗口办理业务"));
                customerNumber++;

                //下面是构建文件流把生成语音文件
           /* ax = new ActiveXComponent("Sapi.SpFileStream");
            Dispatch spFileStream = ax.getObject();

            ax = new ActiveXComponent("Sapi.SpAudioFormat");
            Dispatch spAudioFormat = ax.getObject();
            *//***设置音频格式*//*
            Dispatch.put(spAudioFormat,"Type",new Variant(22));
            *//**设置文件输出格式*//*
            Dispatch.putRef(spFileStream,"Format",spAudioFormat);

            //调用输出 文件流打开方法，创建一个.wav文件
            Dispatch.call(spFileStream, "Open", new Variant("E:\\test.wav"), new Variant(3), new Variant(true));
            //设置声音对象的音频输出流为输出文件对象
            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
            //设置音量 0到100
            Dispatch.put(spVoice, "Volume", new Variant(100));
            //设置朗读速度
            Dispatch.put(spVoice, "Rate", new Variant(-2));
            //开始朗读
            Dispatch.call(spVoice, "Speak", new Variant(str));

            //关闭输出文件
            Dispatch.call(spFileStream, "Close");
            Dispatch.putRef(spVoice, "AudioOutputStream", null);

            spAudioFormat.safeRelease();
            spFileStream.safeRelease();
            spVoice.safeRelease();*/
                ax.safeRelease();
                Thread.sleep(1000);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
