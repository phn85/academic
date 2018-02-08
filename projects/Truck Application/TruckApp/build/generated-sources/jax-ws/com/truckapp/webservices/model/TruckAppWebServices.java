
package com.truckapp.webservices.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TruckAppWebServices", targetNamespace = "http://webservices.truckapp.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TruckAppWebServices {


    /**
     * 
     * @param locationAttributes
     * @return
     *     returns com.truckapp.webservices.model.Location
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "LocationInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "LocationInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.LocationInfo")
    @ResponseWrapper(localName = "LocationInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.LocationInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/LocationInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/LocationInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/LocationInfo/Fault/Exception")
    })
    public Location locationInfo(
        @WebParam(name = "LocationAttributes", targetNamespace = "")
        String locationAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param pricingAttributes
     * @return
     *     returns com.truckapp.webservices.model.Pricing
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "PricingInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "PricingInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.PricingInfo")
    @ResponseWrapper(localName = "PricingInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.PricingInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/PricingInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/PricingInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/PricingInfo/Fault/Exception")
    })
    public Pricing pricingInfo(
        @WebParam(name = "PricingAttributes", targetNamespace = "")
        String pricingAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param paymentAttributes
     * @return
     *     returns com.truckapp.webservices.model.Payment
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "PaymentInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "PaymentInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.PaymentInfo")
    @ResponseWrapper(localName = "PaymentInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.PaymentInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/PaymentInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/PaymentInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/PaymentInfo/Fault/Exception")
    })
    public Payment paymentInfo(
        @WebParam(name = "PaymentAttributes", targetNamespace = "")
        String paymentAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param expenseAttributes
     * @return
     *     returns com.truckapp.webservices.model.Expense
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "ExpenseInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ExpenseInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.ExpenseInfo")
    @ResponseWrapper(localName = "ExpenseInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.ExpenseInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/ExpenseInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/ExpenseInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/ExpenseInfo/Fault/Exception")
    })
    public Expense expenseInfo(
        @WebParam(name = "ExpenseAttributes", targetNamespace = "")
        String expenseAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param employeeAttributes
     * @return
     *     returns com.truckapp.webservices.model.Employee
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "EmployeeInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "EmployeeInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.EmployeeInfo")
    @ResponseWrapper(localName = "EmployeeInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.EmployeeInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/EmployeeInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/EmployeeInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/EmployeeInfo/Fault/Exception")
    })
    public Employee employeeInfo(
        @WebParam(name = "EmployeeAttributes", targetNamespace = "")
        String employeeAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param customerAttributes
     * @return
     *     returns com.truckapp.webservices.model.Customer
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "CustomerInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CustomerInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.CustomerInfo")
    @ResponseWrapper(localName = "CustomerInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.CustomerInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/CustomerInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/CustomerInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/CustomerInfo/Fault/Exception")
    })
    public Customer customerInfo(
        @WebParam(name = "CustomerAttributes", targetNamespace = "")
        String customerAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param transactionAttributes
     * @return
     *     returns com.truckapp.webservices.model.Transaction
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "TransactionInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "TransactionInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.TransactionInfo")
    @ResponseWrapper(localName = "TransactionInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.TransactionInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/TransactionInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/TransactionInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/TransactionInfo/Fault/Exception")
    })
    public Transaction transactionInfo(
        @WebParam(name = "TransactionAttributes", targetNamespace = "")
        String transactionAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param invoiceAttributes
     * @return
     *     returns com.truckapp.webservices.model.Invoice
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "InvoiceInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InvoiceInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.InvoiceInfo")
    @ResponseWrapper(localName = "InvoiceInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.InvoiceInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/InvoiceInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/InvoiceInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/InvoiceInfo/Fault/Exception")
    })
    public Invoice invoiceInfo(
        @WebParam(name = "InvoiceAttributes", targetNamespace = "")
        String invoiceAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param truckAttributes
     * @return
     *     returns com.truckapp.webservices.model.Truck
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "TruckInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "TruckInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.TruckInfo")
    @ResponseWrapper(localName = "TruckInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.TruckInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/TruckInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/TruckInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/TruckInfo/Fault/Exception")
    })
    public Truck truckInfo(
        @WebParam(name = "TruckAttributes", targetNamespace = "")
        String truckAttributes)
        throws Exception_Exception
    ;

    /**
     * 
     * @param ordersAttributes
     * @return
     *     returns com.truckapp.webservices.model.Orders
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "OrdersInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "OrdersInfo", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.OrdersInfo")
    @ResponseWrapper(localName = "OrdersInfoResponse", targetNamespace = "http://webservices.truckapp.com/", className = "com.truckapp.webservices.model.OrdersInfoResponse")
    @Action(input = "http://webservices.truckapp.com/TruckAppWebServices/OrdersInfoRequest", output = "http://webservices.truckapp.com/TruckAppWebServices/OrdersInfoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservices.truckapp.com/TruckAppWebServices/OrdersInfo/Fault/Exception")
    })
    public Orders ordersInfo(
        @WebParam(name = "OrdersAttributes", targetNamespace = "")
        String ordersAttributes)
        throws Exception_Exception
    ;

}
