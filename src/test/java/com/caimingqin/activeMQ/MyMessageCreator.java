package com.caimingqin.activeMQ;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class MyMessageCreator implements MessageCreator {
	public int n = 0;
    private static String str1 = "����ǵ� ";
    private static String str2 = " ��������Ϣ��";
    private String str = "";

    @Override
    public Message createMessage(Session paramSession) throws JMSException {
        if (n == 9) {
            return  paramSession.createTextMessage("end");//����������б�ʾ��9�ε���ʱ�����ͽ�����Ϣ
        }
        str = str1 + n + str2;
        return  paramSession.createTextMessage(str);
    }

}