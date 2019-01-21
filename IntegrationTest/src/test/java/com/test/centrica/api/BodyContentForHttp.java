package com.test.centrica.api;

public class BodyContentForHttp {

	
	public static String getAppointmentBodyContent() {
		return "{\n" + "  \"data\": {\n" + "    \"type\": \"appointments\",\n" + "    \"attributes\": {\n"
				+ "      \"job\": \"xr\",\n" + "      \"trackable\": false,\n" + "      \"cancellable\": false,\n"
				+ "      \"reschedulable\": false,\n" + "      \"combinable\": false,\n"
				+ "      \"priority\": false,\n" + "      \"action\": null,\n" + "      \"telephone-number\": {\n"
				+ "        \"number\": \"07401234583\",\n" + "        \"type\": \"work\"\n" + "      },\n"
				+ "      \"status\": \"null\",\n" + "      \"problem-description\": \"NA\",\n"
				+ "      \"details-for-engineer\": \"Testing for Repair and cover\",\n"
				+ "      \"reference\": \"an official appointment reference\"\n" + "    },\n"
				+ "    \"relationships\": {\n" + "      \"services-products\": {\n" + "        \"data\": [{\n"
				+ "          \"id\": \"BC\",\n" + "          \"type\": \"services-products\"\n" + "        }]\n"
				+ "      },\n" + "      \"address\": {\n" + "        \"data\": {\n"
				+ "          \"id\": \"{{addressIdOne}}\",\n" + "          \"type\": \"addresses\"\n" + "        }\n"
				+ "      }\n" + "    }\n" + "  }\n" + "}";
	}
	
	
	public static String getReCapechaToken(Integer type) {
		String result = "";
		switch (type) {
		case 1:
			// Appointment type
			result = "03AA7ASh2YFAyD0YxGzbid1C-5GghQTv1GMQzHetkc39jubhs_k-qWn2LlH6MU64z3DMUUQ6zVIIxK0w6YT3F3q_JIOOJTPOiXBzC9SICNQro3FroF_BAu3bP54M4NS-3b3pdYWwGpurajTQDX3quSODX736eP5fdl0UEDOuV9yjUop_7agD7My-LMFbP3E_dyia31raIKYHXc8urVmMgcfk_1_Ef9n75N1IQdhQuGN8q_sBJf9bc77PUy-B_0NdZRsB3Y27PRK9-XPEe7K8Pbl53JM89wSMNpZ89HEb808Mxp6ss8Gt_rkbMYJDocq68NGK8T3nJerzTwc5x4rT1iLgOjuxMMr0PgLfY-chYIfyZ-FFjXC6GBC9z_zsK_zh-oMeXGSze2YgeR37F6Lk1GjEB2eQFYyHKLetG-ZuiIIMFRwf4QYdX6V2fqSipmlGP-Y9ShQdM8Hi9hs3WPhQ9WYk5T8vMpFdlE5vi4DyB_-z8qQCw4bFjc8cs";
			break;

		case 2:
			// OrderPayment Type
			result = "03AA7ASh34IZqXN27JRKE8zeLmHwSRtJwrz-GtzA08ffqY2a8ZH7-NrhLlTwOeZclWnbgLZntYMACiGjXGjEqRA8Bj4ydHdqXdVgq5Q61uWmXAbWvLkF2ReHWxiFlp1LQeL-XRWCcgzJRgdkUMOPmrqpzcTN1ArT6X-KsI-FZ9OGduPunbzv3zO9WbVvTUP1jTw3B21rNkxbhWoaVb6EzQk88fG63Z-Hp2pJwBIMh31v87bbfWdxPrs0RI4KlT55Ut2ONwv2Dfmt2i-iRUdiOqJfJguV7oGiOa7Lef9EjAS0bjk7oqPMqWBksM5eKJyRm9sHiJg2XJwfN00PJrQ4BoPUIlacYd7Tc4GM2j5Ad5n2QCLi6kwy2fRPihLlpqAQ4WYkMYWyj6ZM-3U8CZdSuXbySri2gNyKP2RC0-blegYdV7rMc67w3hCnFWT8uxh7oVgcZd83qhvP_X";
			break;
		}
		return result;
	}
	
	public static String getReserveAppointmentBodyContent() {
		return "{\n" + "  \"data\": {\n" + "    \"id\": {{appointment}},\n" + "    \"type\": \"appointments\",\n"
				+ "    \"attributes\": {\n" + "		\"action\": \"reserve\"\n" + "	},\n" + "    \"relationships\": {\n"
				+ "      \"selected-slot\": {\n" + "        \"data\": {\n"
				+ "          \"id\": \"{{first_available_slot_id}}\",\n" + "          \"type\": \"appointment-slots\"\n"
				+ "        }\n" + "      }\n" + "    }\n" + "  }\n" + "}";
	}
	
	public static String getServiceOneOfAccountBodyContent() {
		return "{\n" + "  \"data\": {\n" + "    \"type\": \"services-one-off-accounts\",\n" + "    \"attributes\": {\n"
				+ "      \"title\": \"Mr\",\n" + "      \"first-name\": \"George\",\n"
				+ "      \"middle-name\": \"Walsh\",\n" + "      \"surname\": \"Bush\",\n"
				+ "      \"telephone-number\": {\n" + "        \"number\": \"07455653456\",\n"
				+ "        \"type\": \"mobile\"\n" + "      },\n"
				+ "      \"date-of-birth\": \"1980-04-17T00:00:00+01:00\",\n"
				+ "      \"email\": \"georgewalsh@bgdigitaltest.co.uk\"\n" + "    },\n" + "    \"relationships\": {\n"
				+ "      \"address\": {\n" + "        \"data\": {\n" + "          \"id\": {{addressIdOne}},\n"
				+ "          \"type\": \"addresses\"\n" + "        }\n" + "      },\n"
				+ "      \"services-products\": {\n" + "        \"data\": [\n" + "          {\n"
				+ "            \"id\": \"BC\",\n" + "            \"type\": \"services-products\"\n" + "          }\n"
				+ "        ]\n" + "      }\n" + "    }\n" + "  }\n" + "}";
	}
	
	
	public static String getOrderPaymentBodyContent() {
		return "{\n" + "  \"data\": {\n" + "    \"id\": \"\",\n" + "    \"type\": \"payment-orders\",\n"
				+ "    \"attributes\": {\n" + "      \"amount\": 0.0,\n" + "      \"merchant\": \"RSDC\",\n"
				+ "      \"intent\":\"repair-and-cover\",\n" + "      \"installation\": \"1238196\",\n"
				+ "      \"description\": \"Service Payment\",\n" + "      \"reference\": \"{{customer}}\",\n"
				+ "      \"store-card\": false\n" + "    }\n" + "  } \n" + "}";
	}
	
	


	
	

	
	public static String paymentStatusBodyContent() {
		return "{\n" + "  \"data\": {\n" + "    \"id\": \"{{PaymentOrderId}}\",\n"
				+ "    \"type\": \"payment-orders\",\n" + "    \"attributes\": {\n" + "      \"status\": \"success\",\n"
				+ "      \"mac\": \"6f3260b176686064cbf5e32683dbac9f1f61826527a8142813003ee1cbbab38f\",\n"
				+ "      \"order-key\":\"BRITISHGAS^RSDC^{{customer-payment-order-id}}\"\n" + "    }\n" + "  }\n"
				+ "}";
	}
	
	public static String bookAppointmentBodyContent(){
		return "{\n" + 
				"    \"data\": {\n" + 
				"        \"id\": \"{{appointment}}\",\n" + 
				"        \"attributes\": {\n" + 
				"            \"action\": \"book\",\n" + 
				"            \"reference\": \"{{addressSearchReferenceNumber}}\"\n" + 
				"        },\n" + 
				"        \"relationships\": {\n" + 
				"            \"services-products\": {\n" + 
				"                \"data\": [\n" + 
				"                    {\n" + 
				"                        \"type\": \"services-products\",\n" + 
				"                        \"id\": \"{{ServiceProducts_id 0}}\"\n" + 
				"                    }\n" + 
				"                ]\n" + 
				"            },\n" + 
				"            \"payment-order\": {\n" + 
				"                \"data\": {\n" + 
				"                    \"id\": \"{{paymentOrderID}}\",\n" + 
				"                    \"type\": \"payment-orders\"\n" + 
				"                }\n" + 
				"            },\n" + 
				"            \"customer\": {\n" + 
				"                \"data\": {\n" + 
				"                    \"type\": \"customers\",\n" + 
				"                    \"id\": \"{{customer}}\"\n" + 
				"                }\n" + 
				"            },\n" + 
				"    		\"services-account\": {\n" + 
				"		        \"data\": {\n" + 
				"		              \"id\": \"{{serviceAccountId}}\",\n" + 
				"		              \"type\": \"services-accounts\"\n" + 
				"		         }\n" + 
				"	        }\n" + 
				"        },\n" + 
				"        \"type\": \"appointments\"\n" + 
				"    },\n" + 
				"    \"brand\": \"britishgas\"\n" + 
				"}\n" + 
				"";
	}

	

}
