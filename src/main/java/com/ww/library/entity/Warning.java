package com.ww.library.entity;

import java.util.List;

public class Warning {
    private Integer id;
    private String name;
    private String warningTag;
    private String level;
    private String warningSource;
    private String target;
    private String detail;
    private String appendix;
    private String time;
    private List<Proof> proofs;

    public List<Proof> getProofs() {
        return proofs;
    }

    public void setProofs(List<Proof> proofs) {
        this.proofs = proofs;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarningTag() {
        return warningTag;
    }

    public void setWarningTag(String warningTag) {
        this.warningTag = warningTag;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWarningSource() {
        return warningSource;
    }

    public void setWarningSource(String warningSource) {
        this.warningSource = warningSource;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
