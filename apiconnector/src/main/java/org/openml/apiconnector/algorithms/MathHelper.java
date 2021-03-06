/*
 *  OpenmlApiConnector - Java integration of the OpenML Web API
 *  Copyright (C) 2014 
 *  @author Jan N. van Rijn (j.n.van.rijn@liacs.leidenuniv.nl)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package org.openml.apiconnector.algorithms;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MathHelper {

	public final static DecimalFormat defaultDecimalFormat = new DecimalFormat("#.######", DecimalFormatSymbols.getInstance( Locale.ENGLISH ) );
	public final static DecimalFormat visualDecimalFormat = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance( Locale.ENGLISH ) );
	public final static Double EPSILON = 0.00001;
	
	/**
	 * Calculates the standard deviation of a population. 
	 * 
	 * @param population
	 * @param sample
	 * @return The standard deviation of the population
	 */
	public static double standard_deviation( Double[] population, boolean sample ) {
		if( population.length == 1 ) { return 0.0; }
		
		double variance = 0;
		double mean = sum(population) / population.length;
		
		for( double entry : population ) {
			variance += java.lang.Math.pow(entry - mean, 2);
		}
		variance /= sample ? population.length - 1 : population.length;
		
		return java.lang.Math.sqrt(variance);
	}
	
	/**
	 * Returns the sum of values in an array. 
	 * 
	 * @param array
	 * @return The sum of values in the array
	 */
	public static double sum( Double[] array ) {
		double total = 0;
		for( double add : array ) total += add;
		return total;
	}
	
	/**
	 * Returns the mean of values in an array
	 * 
	 * @param array
	 * @return The mean of the array
	 */
	public static double mean( Double[] array ) {
		return sum(array) / array.length;
	}
	
	/**
	 * Returns the index of the maximal value in a double[] 
	 * 
	 * @param array
	 * @param naturalNumbers
	 * @return The index of the highest number in the array
	 */
	public static int argmax( double[] array, boolean naturalNumbers ) {
		int best = -1;
		double value = (naturalNumbers) ? 0D : Double.MIN_VALUE;
		for( int i = 0; i < array.length; ++i ) {
			if(array[i] > value) {
				value = array[i];
				best = i;
			}
		}
		return best;
	}
}
