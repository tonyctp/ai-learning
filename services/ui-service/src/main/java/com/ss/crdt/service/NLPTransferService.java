package com.ss.crdt.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NLPTransferService {

	public static List<String> getOriginalText(String text) {
		List<String> wordList = new ArrayList<>();
		Properties properties = new Properties();

		properties.put("annotators", "tokenize,ssplit,pos,lemma");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);
		Annotation document = new Annotation(text);
		pipeline.annotate(document);

		List<CoreMap> words = document.get(CoreAnnotations.SentencesAnnotation.class);
		for (CoreMap wordTemp : words) {
			for (CoreLabel token : wordTemp.get(CoreAnnotations.TokensAnnotation.class)) {
				String originalWord = token.get(CoreAnnotations.LemmaAnnotation.class);
				wordList.add(originalWord);
			}
		}
		return wordList;
	}

}
