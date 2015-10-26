package com.validation;

import java.util.ArrayList;
import java.util.List;

public class ViolationMessages {
    private List<ViolationMessage> violationMessage = null;

    public List<ViolationMessage> getViolationMessage() {
        return violationMessage;
    }

    public void setViolationMessage(List<ViolationMessage> messages) {
        this.violationMessage = messages;
    }

    @Override
    public String toString() {
        if (violationMessage != null && violationMessage.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (ViolationMessage message : violationMessage) {
                builder.append("Property ");
                builder.append(message.getAttributename());
                builder.append(" of object ");
                builder.append(message.getObjectname());
                builder.append(" has an invalid value. Value was: ");
                builder.append(message.getAttributevalue());
                builder.append("\n");
            }
            return builder.toString();
        } else
            return null;
    }

    public void add(ViolationMessage msg) {
        if (violationMessage == null) {
            violationMessage = new ArrayList<ViolationMessage>();
        }
        violationMessage.add(msg);
    }

}
