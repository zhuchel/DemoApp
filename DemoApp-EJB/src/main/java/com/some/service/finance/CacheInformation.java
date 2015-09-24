
package com.some.service.finance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cacheInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cacheInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cacheContent">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cacheMemoryStoreSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cacheName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cacheSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cacheStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestCleanup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="requestDetails" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cacheInformation", propOrder = {
    "cacheContent",
    "cacheMemoryStoreSize",
    "cacheName",
    "cacheSize",
    "cacheStatus",
    "requestCleanup",
    "requestDetails"
})
public class CacheInformation {

    @XmlElement(required = true)
    protected CacheInformation.CacheContent cacheContent;
    protected Long cacheMemoryStoreSize;
    protected String cacheName;
    protected Integer cacheSize;
    protected String cacheStatus;
    protected boolean requestCleanup;
    protected boolean requestDetails;

    /**
     * Gets the value of the cacheContent property.
     * 
     * @return
     *     possible object is
     *     {@link CacheInformation.CacheContent }
     *     
     */
    public CacheInformation.CacheContent getCacheContent() {
        return cacheContent;
    }

    /**
     * Sets the value of the cacheContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheInformation.CacheContent }
     *     
     */
    public void setCacheContent(CacheInformation.CacheContent value) {
        this.cacheContent = value;
    }

    /**
     * Gets the value of the cacheMemoryStoreSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCacheMemoryStoreSize() {
        return cacheMemoryStoreSize;
    }

    /**
     * Sets the value of the cacheMemoryStoreSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCacheMemoryStoreSize(Long value) {
        this.cacheMemoryStoreSize = value;
    }

    /**
     * Gets the value of the cacheName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheName() {
        return cacheName;
    }

    /**
     * Sets the value of the cacheName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheName(String value) {
        this.cacheName = value;
    }

    /**
     * Gets the value of the cacheSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCacheSize() {
        return cacheSize;
    }

    /**
     * Sets the value of the cacheSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCacheSize(Integer value) {
        this.cacheSize = value;
    }

    /**
     * Gets the value of the cacheStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheStatus() {
        return cacheStatus;
    }

    /**
     * Sets the value of the cacheStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheStatus(String value) {
        this.cacheStatus = value;
    }

    /**
     * Gets the value of the requestCleanup property.
     * 
     */
    public boolean isRequestCleanup() {
        return requestCleanup;
    }

    /**
     * Sets the value of the requestCleanup property.
     * 
     */
    public void setRequestCleanup(boolean value) {
        this.requestCleanup = value;
    }

    /**
     * Gets the value of the requestDetails property.
     * 
     */
    public boolean isRequestDetails() {
        return requestDetails;
    }

    /**
     * Sets the value of the requestDetails property.
     * 
     */
    public void setRequestDetails(boolean value) {
        this.requestDetails = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class CacheContent {

        protected List<CacheInformation.CacheContent.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CacheInformation.CacheContent.Entry }
         * 
         * 
         */
        public List<CacheInformation.CacheContent.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<CacheInformation.CacheContent.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected Object key;
            protected Object value;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setKey(Object value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

        }

    }

}
