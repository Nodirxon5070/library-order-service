package com.company.orderservice.constants;


public class Constants {

    public static final String EXAMPLE_ORDERSBOOKS_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "loadId": "Value ...",
                    "customerId": "Value ...",
                    "amount": "Value ...",
                    "status": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_ORDERSBOOKS_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Borrower with  :: id is not found"
            }
            """;

    public static final String EXAMPLE_ORDERS_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "loadId": "Value ...",
                    "customerId": "Value ...",
                    "amount": "Value ...",
                    "status": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_ORDERS_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Borrower with  :: id is not found"
            }
            """;


}


