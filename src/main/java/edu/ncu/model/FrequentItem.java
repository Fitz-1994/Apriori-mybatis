package edu.ncu.model;


import edu.ncu.utils.StringUtils;

import java.util.List;

/**
 * 频繁项集
 * @author forward
 */
public class FrequentItem {
    private String id;
    private List<Warning> items;
    private Double support;
    private Double confidence;

    public FrequentItem(){

    }

    public FrequentItem(List<Warning> items, Double support, Double confidence){
        this.id = StringUtils.UUID();
        this.items = items;
        this.support = support;
        this.confidence = confidence;
    }
    public FrequentItem(String id,List<Warning> items, Double support, Double confidence){
        this.id = id;
        this.items = items;
        this.support = support;
        this.confidence = confidence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
