package com.dingxizhe.push.po;

/**
 * ��ע���Ͷ���
 * @author dingxizhe
 */
public class WeiXinPush {
	//������΢�ź�
	private String ToUserName;
	//���ͷ��ʺţ�һ��OpenID��
	private String FromUserName;
	//��Ϣ����ʱ�� �����ͣ�
	private long CreateTime;
	//��Ϣ���ͣ�event
	private String MsgType;
	//�¼����ͣ�subscribe(����)��unsubscribe(ȡ������)
	private String Event;
	//�¼�KEYֵ��qrscene_Ϊǰ׺������Ϊ��ά��Ĳ���ֵ
	private String EventKey;
	//��ά���ticket����������ȡ��ά��ͼƬ
	private String Ticket;
	//����λ��γ��
	private String Latitude;
	//����λ�þ���
	private String Longitude;
	//����λ�þ���
	private String Precision;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	
}
