
package com.lijiao.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lijiao.webservice package. 
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

    private final static QName _GetUserById_QNAME = new QName("http://webservice.lijiao.com/", "GetUserById");
    private final static QName _GetUserById2Response_QNAME = new QName("http://webservice.lijiao.com/", "GetUserById2Response");
    private final static QName _GetUserById2_QNAME = new QName("http://webservice.lijiao.com/", "GetUserById2");
    private final static QName _GetAuthenticate_QNAME = new QName("http://webservice.lijiao.com/", "GetAuthenticate");
    private final static QName _GetAuthenticateResponse_QNAME = new QName("http://webservice.lijiao.com/", "GetAuthenticateResponse");
    private final static QName _GetUserByIdResponse_QNAME = new QName("http://webservice.lijiao.com/", "GetUserByIdResponse");
    private final static QName _ShowAllUsersResponse_QNAME = new QName("http://webservice.lijiao.com/", "ShowAllUsersResponse");
    private final static QName _ShowAllUsers_QNAME = new QName("http://webservice.lijiao.com/", "ShowAllUsers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lijiao.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserById }
     * 
     */
    public GetUserById createGetUserById() {
        return new GetUserById();
    }

    /**
     * Create an instance of {@link GetUserById2Response }
     * 
     */
    public GetUserById2Response createGetUserById2Response() {
        return new GetUserById2Response();
    }

    /**
     * Create an instance of {@link GetUserById2 }
     * 
     */
    public GetUserById2 createGetUserById2() {
        return new GetUserById2();
    }

    /**
     * Create an instance of {@link ShowAllUsersResponse }
     * 
     */
    public ShowAllUsersResponse createShowAllUsersResponse() {
        return new ShowAllUsersResponse();
    }

    /**
     * Create an instance of {@link GetUserByIdResponse }
     * 
     */
    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }

    /**
     * Create an instance of {@link GetAuthenticateResponse }
     * 
     */
    public GetAuthenticateResponse createGetAuthenticateResponse() {
        return new GetAuthenticateResponse();
    }

    /**
     * Create an instance of {@link GetAuthenticate }
     * 
     */
    public GetAuthenticate createGetAuthenticate() {
        return new GetAuthenticate();
    }

    /**
     * Create an instance of {@link ShowAllUsers }
     * 
     */
    public ShowAllUsers createShowAllUsers() {
        return new ShowAllUsers();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "GetUserById")
    public JAXBElement<GetUserById> createGetUserById(GetUserById value) {
        return new JAXBElement<GetUserById>(_GetUserById_QNAME, GetUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "GetUserById2Response")
    public JAXBElement<GetUserById2Response> createGetUserById2Response(GetUserById2Response value) {
        return new JAXBElement<GetUserById2Response>(_GetUserById2Response_QNAME, GetUserById2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "GetUserById2")
    public JAXBElement<GetUserById2> createGetUserById2(GetUserById2 value) {
        return new JAXBElement<GetUserById2>(_GetUserById2_QNAME, GetUserById2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthenticate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "GetAuthenticate")
    public JAXBElement<GetAuthenticate> createGetAuthenticate(GetAuthenticate value) {
        return new JAXBElement<GetAuthenticate>(_GetAuthenticate_QNAME, GetAuthenticate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthenticateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "GetAuthenticateResponse")
    public JAXBElement<GetAuthenticateResponse> createGetAuthenticateResponse(GetAuthenticateResponse value) {
        return new JAXBElement<GetAuthenticateResponse>(_GetAuthenticateResponse_QNAME, GetAuthenticateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "GetUserByIdResponse")
    public JAXBElement<GetUserByIdResponse> createGetUserByIdResponse(GetUserByIdResponse value) {
        return new JAXBElement<GetUserByIdResponse>(_GetUserByIdResponse_QNAME, GetUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "ShowAllUsersResponse")
    public JAXBElement<ShowAllUsersResponse> createShowAllUsersResponse(ShowAllUsersResponse value) {
        return new JAXBElement<ShowAllUsersResponse>(_ShowAllUsersResponse_QNAME, ShowAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lijiao.com/", name = "ShowAllUsers")
    public JAXBElement<ShowAllUsers> createShowAllUsers(ShowAllUsers value) {
        return new JAXBElement<ShowAllUsers>(_ShowAllUsers_QNAME, ShowAllUsers.class, null, value);
    }

}
