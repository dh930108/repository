package com.mether.call;

import java.util.ArrayList;

public class BoardVO {
	int bseq;
	String title;
	String content;
	ArrayList<ReplyVO> reply;
	public ArrayList<ReplyVO> getReply() {
		return reply;
	}
	public void setReply(ArrayList<ReplyVO> reply) {
		this.reply = reply;
	}
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
