package com.example.resource.rxmessage;

/**
 * @author Zhao Chenping
 * @creat 2017/8/21.
 * @description
 */

public class RxBusMessageForText {

    String moduleMessage;

    public RxBusMessageForText(String moduleMessage) {
        this.moduleMessage = moduleMessage;
    }

    public String getModuleMessage() {
        return moduleMessage;
    }

    public void setModuleMessage(String moduleMessage) {
        this.moduleMessage = moduleMessage;
    }

}
