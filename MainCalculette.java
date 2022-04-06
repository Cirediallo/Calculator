import java.io.*;
import org.antlr.v4.runtime.*;

public class MainCalculette
{
	public static void main(String args[])
	{
		try
		{
			CalculatorLexer lexer = null;
			
			if( args.length > 0 )
			{
				lexer = new CalculatorLexer(new ANTLRInputStream(new FileInputStream(args[0])));
			}
			else
			{
				lexer = new CalculatorLexer(new ANTLRInputStream(System.in));
			}
			
			CalculatorParser parser = new CalculatorParser(null);
			
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser.setInputStream(tokens);
			parser.calcul();
		}
		catch( Exception e )
		{
		}
	}
}
