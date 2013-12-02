<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ajax Demo</title>
	</head>
	<body>
		<h1 align="center" >String reversion</h1>
		<hr />
		<span>Input String: </span><input id="str" name="str" value="..." /><br />
		<p id="rstr" >&lt;no data&gt;</p><br />
		<input id="subm" type="submit" name="Do" value="Reverse!" />
		
		<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.2.min.js" ></script>
		<script type="text/javascript" >
			$( document ).ready( function( )
			{
				$( "#subm" ).click( function( )
				{
					$.ajax(
					{
						url: "postx",
						type: "POST",
						data: JSON.stringify( { str: $( "#str" ).attr( "value" ) } ),
						contentType:"application/json; charset=utf-8",
						dataType:"json",
						success: function( data )
						{
							if ( data.status == 'ok' )
							{
								$( "#rstr" ).html( data.str );
							}
							else
							{
								$( "#rstr" ).html( "&lt;Server Error&gt;" );	
							}
						}
					} );
				} );
			} );
		</script>
	</body>
</html>