package com.github.kb2.mains;

import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;

public class TypesafeConfigTestMain {

	public static void main(String args[]) {

		// コンフィグのパスがシステム設定値にあるか確認。ここに指定がなければ、「application.conf」を使用する
		String configResource = System.getProperty("config.resource");
		System.out.println("configResource : " + configResource);
		
		// コンフィグを取得する
		Config config = ConfigFactory.load();
		
		// 文字取得
		String word1 = config.getString("word1");
		System.out.println("word1 : " + word1);
		
		// 配列取得
		List<Integer> array1 = config.getIntList("array1");
		System.out.println("array1 : " + array1);
		
		// オブジェクト取得
		ConfigObject object1 = config.getObject("object1");
		System.out.println("object1 : " + object1);
		
		// 値の使い回し結果取得
		String timeout = config.getString("foo.timeout");
		System.out.println("timeout : " + timeout);
		
		// 環境変数結果取得
		String path = config.getString("env.path");
		System.out.println("env.path : " + path);
	}
}
