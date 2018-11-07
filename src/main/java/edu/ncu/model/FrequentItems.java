package edu.ncu.model;

import java.util.List;

/**
 * 频繁项集
 * @author forward
 */
public class FrequentItems {
    private List<Warning> items;
    private Double support;
    private Double confidence;

    public FrequentItems(List<Warning> items,Double support,Double confidence){
        this.items = items;
        this.support = support;
        this.confidence = confidence;
    }

    public List<Warning> getItems() {
        return items;
    }

    public void setItems(List<Warning> items) {
        this.items = items;
    }

    public Double getSupport() {
        return support;
    }

    public void setSupport(Double support) {
        this.support = support;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
