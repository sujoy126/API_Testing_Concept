package task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * {
"links": {
"self": {"href": "/orders" },
"next":{"href": "/orders?page=2"}
},
"results": [
{
"id": 7235,
"total": 78.22,
"customerId": 9001
},
{
"id": 7236,
"total": 301.97,
"customerId": 9200
},
]
}
 */

class Self{
	String href;

	public Self(String href) {
		super();
		this.href = href;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}

class Next{
	String href;

	public Next(String href) {
		super();
		this.href = href;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
		
}

class Links{
	Self self;
	Next next;
	public Links(Self self, Next next) {
		super();
		this.self = self;
		this.next = next;
	}
	public Self getSelf() {
		return self;
	}
	public void setSelf(Self self) {
		this.self = self;
	}
	public Next getNext() {
		return next;
	}
	public void setNext(Next next) {
		this.next = next;
	}
	
	
}





class Results{
	int id ;
	double total;
	int customerId;
	
	public Results(int id, double total, int customerId) {
		super();
		this.id = id;
		this.total = total;
		this.customerId = customerId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}

class Super{
	Links links;
	List<Results> results;
	
	public Super(Links links, List<Results> results) {
		super();
		this.links = links;
		this.results = results;
	}
	
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	
	
}



public class GetOrders {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Self sf = new Self("/orders");
		Next nx = new Next("/orders?page=2");
		
		Links lk = new Links(sf, nx);
		
		List<Results> resultList = new ArrayList<>();
		resultList.add(new Results(7235, 078.22, 9001));
		resultList.add(new Results(7236, 301.97, 9200));
		
		Super sp = new Super(lk, resultList);
		
		ObjectMapper objM =new ObjectMapper();
		objM.writerWithDefaultPrettyPrinter().writeValue(new File("./Orders.json"), sp);
		System.out.println("====Order Succesful=======");
		
		
	}

}
