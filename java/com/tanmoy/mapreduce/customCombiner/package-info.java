/**
 * In the novel “Alice’s Adventures in Wonderland” that you downloaded in the previous segment,
 *  write a MapReduce program that uses a combiner to compute the average length of words in the text document. The counting operation should not take numbers 
 *  and punctuations into account, i.e. the length of “So” and “so,” 
 *  should be considered as 2 each, and standalone numbers and punctuations like “...” 
 *  and "100" should not be counted at all.

What is the total number of words in the document(according to the problem specifications) and what is their average length?
 */
/**
 * @author Tanmoy
 *
 */
package com.tanmoy.mapreduce.customCombiner;