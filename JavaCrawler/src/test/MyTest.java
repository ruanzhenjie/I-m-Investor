package test;

import java.util.List;

import org.web.tool.ExtractService;
import org.web.tool.LinkTypeData;
import org.web.tool.Rule;

import junit.framework.TestCase;

public class MyTest extends TestCase {

	public void testExtract() {
		//fail("Not yet implemented");
		Rule rule = new Rule("https://list.lu.com/list/all",null, null,"product-list", Rule.CLASS, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		assertTrue(extracts.size()>0);
	}

}
