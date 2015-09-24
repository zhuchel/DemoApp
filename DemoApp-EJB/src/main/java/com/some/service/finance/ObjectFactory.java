
package com.some.service.finance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.some.service.finance package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCacheManagerInformation_QNAME = new QName("http://some.com/service/finance", "getCacheManagerInformation");
    private final static QName _GetCacheManagerInformationResponse_QNAME = new QName("http://some.com/service/finance", "getCacheManagerInformationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.some.service.finance
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CacheInformation }
     * 
     */
    public CacheInformation createCacheInformation() {
        return new CacheInformation();
    }

    /**
     * Create an instance of {@link CacheInformation.CacheContent }
     * 
     */
    public CacheInformation.CacheContent createCacheInformationCacheContent() {
        return new CacheInformation.CacheContent();
    }

    /**
     * Create an instance of {@link GetCacheManagerInformation }
     * 
     */
    public GetCacheManagerInformation createGetCacheManagerInformation() {
        return new GetCacheManagerInformation();
    }

    /**
     * Create an instance of {@link GetCacheManagerInformationResponse }
     * 
     */
    public GetCacheManagerInformationResponse createGetCacheManagerInformationResponse() {
        return new GetCacheManagerInformationResponse();
    }

    /**
     * Create an instance of {@link CacheManagerInformation }
     * 
     */
    public CacheManagerInformation createCacheManagerInformation() {
        return new CacheManagerInformation();
    }

    /**
     * Create an instance of {@link CacheInformation.CacheContent.Entry }
     * 
     */
    public CacheInformation.CacheContent.Entry createCacheInformationCacheContentEntry() {
        return new CacheInformation.CacheContent.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCacheManagerInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://some.com/service/finance", name = "getCacheManagerInformation")
    public JAXBElement<GetCacheManagerInformation> createGetCacheManagerInformation(GetCacheManagerInformation value) {
        return new JAXBElement<GetCacheManagerInformation>(_GetCacheManagerInformation_QNAME, GetCacheManagerInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCacheManagerInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://some.com/service/finance", name = "getCacheManagerInformationResponse")
    public JAXBElement<GetCacheManagerInformationResponse> createGetCacheManagerInformationResponse(GetCacheManagerInformationResponse value) {
        return new JAXBElement<GetCacheManagerInformationResponse>(_GetCacheManagerInformationResponse_QNAME, GetCacheManagerInformationResponse.class, null, value);
    }

}
