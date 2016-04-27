package org.web.tool;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.TextUI;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 
 * @author zhy
 * 
 */
public class ExtractService
{
	/**
	 * @param rule
	 * @return
	 */
	public static List<LinkTypeData> extract(Rule rule)
	{

		// ���ж�rule�ı�ҪУ��
		validateRule(rule);

		List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
		LinkTypeData data = null;
		try
		{
			/**
			 * ����rule
			 */
			String url = rule.getUrl();
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			String resultTagName = rule.getResultTagName();
			int type = rule.getType();
			int requestType = rule.getRequestMoethod();

			Connection conn = Jsoup.connect(url);
			// ���ò�ѯ����

			if (params != null)
			{
				for (int i = 0; i < params.length; i++)
				{
					conn.data(params[i], values[i]);
				}
			}

			// ������������
			Document doc = null;
			switch (requestType)
			{
			case Rule.GET:
				doc = conn.timeout(100000).get();
				break;
			case Rule.POST:
				doc = conn.timeout(100000).post();
				break;
			}

			//������������
			Elements results = new Elements();
			switch (type)
			{
			case Rule.CLASS:
				results = doc.getElementsByClass(resultTagName);
//				System.out.print(results.size());
				break;
			case Rule.ID:
				Element result = doc.getElementById(resultTagName);
				results.add(result);
				break;
			case Rule.SELECTION:
				results = doc.select(resultTagName);
				break;
			default:
				//��resultTagNameΪ��ʱĬ��ȥbody��ǩ
				if (TextUtil.isEmpty(resultTagName))
				{
					results = doc.getElementsByTag("body");
				}
			}

			for (Element result : results)
			{
				Elements links = result.getElementsByTag("a");

				for (Element link : links)
				{
					//��Ҫ��ɸѡ
					String linkHref = link.attr("href");
					String linkText = link.text();

					data = new LinkTypeData();
					data.setLinkHref(linkHref);
					data.setLinkText(linkText);
					if(result.getElementsByClass("interest-rate").size()>0){
					Element elerate=result.getElementsByClass("interest-rate").get(0);
					data.setInterestRate(elerate.getElementsByClass("product-property-name").text());
					data.setRate(elerate.getElementsByClass("num-style").text());
					}

					datas.add(data);
				}
				
				
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return datas;
	}

	/**
	 * �Դ���Ĳ������б�Ҫ��У��
	 */
	private static void validateRule(Rule rule)
	{
		String url = rule.getUrl();
		if (TextUtil.isEmpty(url))
		{
			throw new RuleException("url����Ϊ�գ�");
		}
		if (!(url.startsWith("https://")||url.startsWith("https://")))
		{
			throw new RuleException("url�ĸ�ʽ����ȷ��");
		}

		if (rule.getParams() != null && rule.getValues() != null)
		{
			if (rule.getParams().length != rule.getValues().length)
			{
				throw new RuleException("�����ļ�ֵ�Ը�����ƥ�䣡");
			}
		}

	}


}