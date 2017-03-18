package org.apache.lucene.analysis;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.util.AttributeSource;

/** A WhitespaceTokenizer is a tokenizer that divides text at whitespace.
 * Adjacent sequences of non-Whitespace characters form tokens. */

public class CustomTokenizer extends CharTokenizer {
	
	char [] delim = {' ','\t','\n','\r','`','~','!','@','#','$',
			'%','^','&','*','(',')','_','=','+','|','[',';',']',
			'{','}',',','.','?','<','>',':','\'','\\','"' };
	Set<Character> chars = new HashSet<Character>();
	
  /** Construct a new WhitespaceTokenizer. */
  public CustomTokenizer(Reader in) {
    super(in);
    for(int i=0;i<delim.length;i++){
    	chars.add(delim[i]);
    }
  }

  /** Construct a new WhitespaceTokenizer using a given {@link AttributeSource}. */
  public CustomTokenizer(AttributeSource source, Reader in) {
    super(source, in);
    for(int i=0;i<delim.length;i++){
    	chars.add(delim[i]);
    }
  }

  /** Construct a new WhitespaceTokenizer using a given {@link org.apache.lucene.util.AttributeSource.AttributeFactory}. */
  public CustomTokenizer(AttributeFactory factory, Reader in) {
    super(factory, in);
    for(int i=0;i<delim.length;i++){
    	chars.add(delim[i]);
    }
  }
  
  /** Collects only characters which do not satisfy
   * {@link Character#isWhitespace(char)}.*/
  @Override
  protected boolean isTokenChar(char c) {
	  return !chars.contains(c);
    // return Character.isLetter(c) || c == '-'; // || Character.isDigit(c) || c == '/';
  }
}
