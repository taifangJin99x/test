package com.example.demo.com.by.factory.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchang on 2017/7/25.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;

    /**
     * id: 如果没有的话，就自动生成
     */
    private String id ;

    /**
     * 消息类型(服务名称+功能名称 如: esen_word_createword)
     */
    private String eventType;

    /**
     * 消息源，由MTC SDK自动从服务中的配置文件获取
     */
    private String currentServerName;

    private String endPoint = "message";

    private Map<String, String> params = new HashMap<>();
    private String messageDisplayGroup;
    private String groupId;
    private Map<String, String> bizMap;
    private Map<String, String> assistantMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCurrentServerName() {
        return currentServerName;
    }

    public void setCurrentServerName(String currentServerName) {
        this.currentServerName = currentServerName;
    }



    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getMessageDisplayGroup() {
        return messageDisplayGroup;
    }

    public void setMessageDisplayGroup(String messageDisplayGroup) {
        this.messageDisplayGroup = messageDisplayGroup;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Map<String, String> getBizMap() {
        return bizMap;
    }

    public void setBizMap(Map<String, String> bizMap) {
        this.bizMap = bizMap;
    }

    public Map<String, String> getAssistantMap() {
        return assistantMap;
    }

    public void setAssistantMap(Map<String, String> assistantMap) {
        this.assistantMap = assistantMap;
    }

    @Override
    public String toString() {
        return "Message{" +
                "eventType='" + eventType + '\'' +
                ", currentServerName='" + currentServerName + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", params=" + params +
                ", messageDisplayGroup='" + messageDisplayGroup + '\'' +
                ", groupId='" + groupId + '\'' +
                ", bizMap=" + bizMap +
                ", assistantMap=" + assistantMap +
                '}';
    }
}
