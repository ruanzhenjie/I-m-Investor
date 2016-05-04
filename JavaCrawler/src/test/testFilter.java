package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.web.tool.ExtractService;
import org.web.tool.ProjectData;
import org.web.tool.ProjectFilter;
import org.web.tool.Rule;

public class testFilter {

	@Test
	public void test() {
		//fail("Not yet implemented");
		ProjectFilter PF=new ProjectFilter();
		PF.setAmount("0", "10000");
		Rule rule = new Rule(PF.getURL(),null, null,"product-list", Rule.CLASS, Rule.GET);
		//Rule rule = new Rule("https://list.lu.com/list/p2p?minMoney=&maxMoney=&minDays=0&maxDays=180&minRate=&maxRate=&mode=&tradingMode=&isCx=&currentPage=1&orderCondition=&isShared=&canRealized=&productCategoryEnum=",null, null,"product-list", Rule.CLASS, Rule.GET);
		List<ProjectData> extracts = ExtractService.extract(rule);
		assertTrue(extracts.size()>0);
	}

}
