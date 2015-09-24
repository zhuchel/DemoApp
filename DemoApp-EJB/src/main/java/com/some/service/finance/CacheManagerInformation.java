
package com.some.service.finance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cacheManagerInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cacheManagerInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cacheInformation" type="{http://some.com/service/finance}cacheInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cacheManagerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cacheManagerInformation", propOrder = {
    "cacheInformation",
    "cacheManagerId"
})
public class CacheManagerInformation {

    @XmlElement(nillable = true)
    protected List<CacheInformation> cacheInformation;
    protected String cacheManagerId;

    /**
     * Gets the value of the cacheInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cacheInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCacheInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CacheInformation }
     * 
     * 
     */
    public List<CacheInformation> getCacheInformation() {
        if (cacheInformation == null) {
            cacheInformation = new ArrayList<CacheInformation>();
        }
        return this.cacheInformation;
    }

    /**
     * Gets the value of the cacheManagerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheManagerId() {
        return cacheManagerId;
    }

    /**
     * Sets the value of the cacheManagerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheManagerId(String value) {
        this.cacheManagerId = value;
    }

}
