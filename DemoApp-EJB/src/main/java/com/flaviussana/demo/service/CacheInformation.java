
package com.flaviussana.demo.service;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.Map;

public final class CacheInformation implements Serializable {

  private static final long serialVersionUID = -1;
  private Map<Object, Object> cacheContent;
  private Long cacheMemoryStoreSize;
  private String cacheName;
  private Integer cacheSize;
  private String cacheStatus;
  private boolean requestCleanup;
  private boolean requestDetails;

  /**
   * Method getCacheContent.
   *
   * @return The content of the cache
   */
  public Map<Object, Object> getCacheContent() {
    return cacheContent;
  }

  /**
   * Method setCacheContent.
   *
   * @param cacheContent The content of the cache
   */
  public void setCacheContent(final Map<Object, Object> cacheContent) {
    this.cacheContent = cacheContent;
  }

  /**
   * Method isRequestDetails.
   * @return Indicator if cache details are requested (for support purposes)
   */
  public boolean isRequestDetails() {
    return requestDetails;
  }

  /**
   * Method isRequestCleanup.
   * @param pRequestDetails Indicator if cache details are requested (for support purposes)
   */
  public void setRequestDetails(final boolean pRequestDetails) {
    this.requestDetails = pRequestDetails;
  }

  /**
   * Method isRequestCleanup.
   * @return Indicator if cache shall be cleared (for support purposes)
   */
  public boolean isRequestCleanup() {
    return requestCleanup;
  }

  /**
   * Method setRequestCleanup.
   * @param pRequestCleanup Indicator if cache shall be cleared (for support purposes)
   */
  public void setRequestCleanup(final boolean pRequestCleanup) {
    this.requestCleanup = pRequestCleanup;
  }

  /**
   * Metthod getCacheMemoryStoreSize.
   *
   * @return The cache memory size
   */
  public Long getCacheMemoryStoreSize() {
    return cacheMemoryStoreSize;
  }

  /**
   * Method
   *
   * @param pCacheMemoryStoreSize The cache memory size
   */
  public void setCacheMemoryStoreSize(final Long pCacheMemoryStoreSize) {
    this.cacheMemoryStoreSize = pCacheMemoryStoreSize;
  }

  /**
   * Method getCacheName.
   *
   * @return The cache name
   */
  public String getCacheName() {
    return cacheName;
  }

  /**
   * Method setCacheName.
   *
   * @param pCacheName The cache name
   */
  public void setCacheName(final String pCacheName) {
    this.cacheName = pCacheName;
  }

  /**
   * Method getCacheSize.
   *
   * @return The cache size
   */
  public Integer getCacheSize() {

    return cacheSize;
  }

  /**
   * Method setCacheSize.
   *
   * @param pCacheSize The cache size
   */
  public void setCacheSize(final Integer pCacheSize) {
    this.cacheSize = pCacheSize;
  }

  /**
   * Method getCacheStatus.
   *
   * @return The cache status
   */
  public String getCacheStatus() {

    return cacheStatus;
  }

  /**
   * Method setCacheStatus.
   *
   * @param pCacheStatus The cache status
   */
  public void setCacheStatus(final String pCacheStatus) {
    this.cacheStatus = pCacheStatus;
  }

  /**
   * Method description.
   *
   *
   * @return
   */
  @Override
  public String toString() {
    final StringBuffer result = new StringBuffer();

    result.append(cacheName);
    result.append(": status=");
    result.append(cacheStatus);
    result.append(" elements=");
    result.append(cacheSize);
    result.append(" elementsInMemory=");
    result.append(cacheMemoryStoreSize);

    return result.toString();
  }
}
