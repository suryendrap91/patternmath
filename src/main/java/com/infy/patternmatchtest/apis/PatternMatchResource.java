package com.infy.patternmatchtest.apis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pattern")
public class PatternMatchResource {

	@GetMapping(value = "/match/{parentString}/{childString}")
	public Map<String, Boolean> match(@PathVariable("parentString") String parentString,
			@PathVariable("childString") String childString) {
		Map<String, Boolean> resultMap = new HashMap<>();

		char parentCharArr[] = parentString.toCharArray();
		char childCharArr[] = childString.toCharArray();
		boolean match = true;
		int parentIndex = 0;
		for (int k = 0; k <= parentCharArr.length - 1; k++) {
			if (childCharArr[0] == parentCharArr[k]) {
				parentIndex = k;
			}
		}
        int c=0;
        int matchCnt = 0;
		for (int p = parentIndex; p <= parentCharArr.length - 1; p++,c++) {
			if (c<=childCharArr.length-1 && childCharArr[c] != parentCharArr[p]) {
				match = false;
			}
			else {
				matchCnt++;
			}
		}
		
		resultMap.put("message", match);
		return resultMap;
	}

	@GetMapping(value = "/test")
	public String test() {
		return "Sample Ping";
	}

}
