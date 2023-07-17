package com.obsqura.utilities;

public class StringUtility {

	String s="Hello World";

	String s1="Welcome";

	public int StringLength() {

		return s.length();

		}

	public char charactor() {

		return s.charAt(2);

		}

	public String concatString() {

		return s.concat(s);

		}

	public boolean stringEquals() {

		return s.equals(s1);

		}

	public boolean stringEqualIgnore() {

		return s.equalsIgnoreCase(s1);

		}

	public String returnUpperCase() {

		return s.toUpperCase();

		}

	public String returnLowerCase() {

		return s.toLowerCase();

		}

	public String replaceLetter() {

		return s.replace('H', 'M');

	}

	}

