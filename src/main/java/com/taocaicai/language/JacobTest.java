package com.taocaicai.language;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class JacobTest {
    public static void main(String[] args) {
        ActiveXComponent ax = null;
        int customerNumber = 1;
        while (true) {
            try {
                Random random = new Random();
                int windowsNumber = random.nextInt(5);
                windowsNumber=windowsNumber==0?1:windowsNumber;

                ax = new ActiveXComponent("Sapi.SpVoice");
                /**运行时输出语音内容*/
                Dispatch spVoice = ax.getObject();
                ax.setProperty("Volume", new Variant(100));
                /**语音朗读速度 -10 到 +10*/
                ax.setProperty("Rate", new Variant(-2));
                /**执行朗读*/
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Dispatch.call(spVoice, "Speak", new Variant("请" + customerNumber + "号到" + windowsNumber + "窗口办理业务"));
                Dispatch.call(spVoice, "Speak", new Variant(br.readLine()));
                customerNumber++;
                spVoice.safeRelease();
                ax.safeRelease();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
