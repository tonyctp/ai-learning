package com.ss.crdt.bean;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChatClientBean {

    private String id;
    private String content;
    private String extras;
    @JsonPropertyDescription("resourceKey")
    private String resourcekey;
    private int timestamp;
    private String title;
    @JsonPropertyDescription("userId")
    private String userid;
    private List<String> tags;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public void setExtras(String extras) {
         this.extras = extras;
     }
     public String getExtras() {
         return extras;
     }

    public void setResourcekey(String resourcekey) {
         this.resourcekey = resourcekey;
     }
     public String getResourcekey() {
         return resourcekey;
     }

    public void setTimestamp(int timestamp) {
         this.timestamp = timestamp;
     }
     public int getTimestamp() {
         return timestamp;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setUserid(String userid) {
         this.userid = userid;
     }
     public String getUserid() {
         return userid;
     }

    public void setTags(List<String> tags) {
         this.tags = tags;
     }
     public List<String> getTags() {
         return tags;
     }

}