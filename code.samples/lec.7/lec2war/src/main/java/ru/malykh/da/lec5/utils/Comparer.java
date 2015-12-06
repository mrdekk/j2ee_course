package ru.malykh.da.lec5.utils;

public class Comparer
{
	public static < T > boolean equals( T obj1, T obj2 )
	{
		if ( null == obj1 && null == obj2 )
			return true;
		
		if ( null == obj1 && null != obj2 )
			return false;
		if ( null != obj1 && null == obj2 )
			return false;
		
		return obj1.equals( obj2 );
	}
}
