grammar Calculator;

@parser::members
{
	// global variables count
	// used to pop all global variables later
	private int varg_count = 0;
	private int floatg_count = 0;
	
	// used to store the variables
	private TablesSymboles tablesSymboles = new TablesSymboles();
	
	// for use with "while" instruction
	private int _label = 0;
	
	private int nextLabel()
	{
		return _label++;
	}
	
	private int evalexpr(int x, int op, int y)
	{
		switch( op )
		{
			case MUL:
				return x * y;
			case DIV:
				return x / y;
			case ADD:
				return x + y;
			case SUB:
				return x -y;
			default:
				throw new UnsupportedOperationException("Unknown operation: " + op + "\n");
		}
	}
	
	private String makeinstruction(int op, String vartype)
	{
		switch( op )
		{
			case MUL:
				if( vartype.equals("int") )
				{
					return "MUL\n";
				}
				else if( vartype.equals("float") )
				{
					return "FMUL\n";
				}
			case DIV:
				if( vartype.equals("int") )
				{
					return "DIV\n";
				}
				else if( vartype.equals("float") )
				{
					return "FDIV\n";
				}
			case ADD:
				if( vartype.equals("int") )
				{
					return "ADD\n";
				}
				else if( vartype.equals("float") )
				{
					return "FADD\n";
				}
			case SUB:
				if( vartype.equals("int") )
				{
					return "SUB\n";
				}
				else if( vartype.equals("float") )
				{
					return "FSUB\n";
				}
			default:
				throw new UnsupportedOperationException("Unknown operation: " + op + "\n");
		}
	}
	
	// evaluate conditional expression
	private String evalcondition(int op, String vartype)
	{
		System.err.println("vartype: " + vartype);
		switch( op )
		{
			case EQUAL:
				if( vartype.equals("int") )
				{
					return "EQUAL\n";
				}
				else if( vartype.equals("float") )
				{
					return "FEQUAL\n";
				}
			case DIFFERENT:
				if( vartype.equals("int") )
				{
					return "NEQ\n";
				}
				else if( vartype.equals("float") )
				{
					return "FNEQ\n";
				}
			case SUP:
				if( vartype.equals("int") )
				{
					return "SUP\n";
				}
				else if( vartype.equals("float") )
				{
					return "FSUP\n";
				}
			case INF:
				if( vartype.equals("int") )
				{
					return "INF\n";
				}
				else if( vartype.equals("float") )
				{
					return "FINF\n";
				}
			case SUP_EQ:
				if( vartype.equals("int") )
				{
					return "SUPEQ\n";
				}
				else if( vartype.equals("float") )
				{
					return "FSUPEQ\n";
				}
			case INF_EQ:
				if( vartype.equals("int") )
				{
					return "INFEQ\n";
				}
				else if( vartype.equals("float") )
				{
					return "FINFEQ\n";
				}
			default:
				throw new UnsupportedOperationException("Unknown condition: " + op + "\n");
		}
	}
	
	public void incfloatg_count()
	{
		floatg_count++;
	}
	
	public int getfloatg_count()
	{
		return floatg_count;
	}
	
	public void incvarg_count()
	{
		varg_count++;
	}
	
	public int getvarg_count()
	{
		return varg_count;
	}
}

calcul returns [String code]
	@init
		{
			$code = new String();
		}
	@after
		{
   			System.out.print($code);
			for( int i = 0; i < getvarg_count(); ++i )
			{
				System.out.println("POP");
			}
			for( int i = 0; i < getfloatg_count(); ++i )
			{
				System.out.println("POPF");
			}
			System.out.println("HALT");
		}
	: (decl
		{
			// declaration
			$code += $decl.code;
		})*
		{
			int entry = nextLabel();
			$code += "JUMP " + entry + "\n";
		}
	  NEWLINE*
		{
			$code += "";
		}
	  (fonction
	  	{
	  		$code += $fonction.code;
	  	})*
	  NEWLINE*
	  	{
	  		$code += "";
	  	}
	  	{
	  		$code += "LABEL " + entry + "\n";
	  	}
	  (instruction
   		{
   			// instruction, eg. x = 5; 7 * 4;
   			$code += $instruction.code;
   		})*
   	;

decl returns [String code]
	: TYPE IDENTIFIANT '=' expr FININSTRUCTION
		{
			if( $TYPE.text.equals("int") )
			{
				// int a = 5;
				// store the variable in the symbol table
				// push it on the stack
				// increase variable count
				incvarg_count();
				
				tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
				$code = "PUSHI 0\n";
				$code += $expr.code;
				// get address of variable
				AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
				$code += "STOREG " + at.adresse + "\n";
			}
			else if( $TYPE.text.equals("float") )
			{
				tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
				$code = $expr.code;
				incfloatg_count();
			}
			else
			{
				try
				{
					throw new Exception("Unidentified type: " + $TYPE.text);
				}
				catch( Exception e )
				{
					e.printStackTrace();
					System.exit(-1);
				}
			}
		}
	| TYPE IDENTIFIANT FININSTRUCTION
		{
			incvarg_count();
			$code = new String();
			// int a;
			// store the variable in the symbol table
			// push it on the stack
			tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
			$code += "PUSHI 0\n";
		}
	;

// function can have zero or more parameters
fonction returns [String code]
	@init
		{
			int params_size = 0;
			$code = new String();
			tablesSymboles.newTableLocale();
		}
	@after
		{
			tablesSymboles.dropTableLocale();
		}
	: TYPE IDENTIFIANT
		{
			// start by putting the function in the table of functions
			int func_label = nextLabel();
			// function name, label number, function type
			tablesSymboles.nouvelleFonction($IDENTIFIANT.text, func_label, $TYPE.text);
			// add label to the function
			$code += "LABEL " + func_label + "\n";
		}
	  '(' (params
	  		{
	  			$code += $params.code;
	  			params_size = $params.size;
	  		})? ')'
	  block
		{
			// function body
			$code += $block.code;
			
			// position of return value in stack, -3 if there are no parameters
			int ret_val_pos = -3;
			if( params_size > 0 )
			{
				ret_val_pos -= params_size;
			}
			
			$code += "STOREL " + ret_val_pos + "\n";
			$code += "RETURN\nRETURN\n";
		}
	;

params returns [String code, int size]
	@init
		{
			$code = new String();
			$size = 0;
		}
	: TYPE IDENTIFIANT
		{
			// java code to define parameters
			// eg. int x, float y
			
			// add parameter to the local table
			tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
			$size += 1;
		}
	  (',' TYPE IDENTIFIANT
	  	{
	  		// java code to define more parameters
	  		System.out.println("more params found");
			// add parameter to the local table
			tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
	  		$size += 1;
	  	})*
	;

// function can have zero arguments but $args will not be null
args returns [String code, int size]
	@init
		{
			$code = new String();
			$size = 0;
		}
	: (expr
		{
			// java code for first expression for arg1
			$code += $expr.code;
			$size += 1;
		}
	  (',' expr
	  	{
	  		// java code for the next expression - argi
			$code += $expr.code;
			$size += 1;
	  	})*
	  )?
	;

instruction returns [String code]
	: expr FININSTRUCTION
		{
			$code = $expr.code;
		}
	| assignation FININSTRUCTION
		{
			$code = $assignation.code;
		}
	| RETURN expr FININSTRUCTION
		{
			// return expression
			$code = $expr.code;
		}
	| READLN '(' IDENTIFIANT ')' FININSTRUCTION
		{
			// get address of identifiant
			$code = "";
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
			if( at != null )
			{
				String addr = "" + at.adresse;
				// read input from the terminal
				$code += "READ\n";
				// store the input in address
				$code += "STOREG " + addr + "\n";
			}
		}
	| PRINTLN '(' IDENTIFIANT ')' FININSTRUCTION
		{
			// get address of identifiant
			// PUSHG [addr]
			// print it with WRITE
			$code = "";
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
			if( at != null )
			{
				int addr = at.adresse;
				// write the variable and pop it immediately after return
				if( at.type.equals("float") )
				{
					// printing a float, use WRITEF
					// requires two pushg apparently
					$code += "PUSHG " + addr + "\n";
					$code += "PUSHG " + (addr + 1) + "\n";
					$code += "WRITEF\nPOPF\n";
				}
				else if( at.type.equals("int") )
				{
					// printing an int, use WRITE
					$code += "PUSHG " + addr + "\n";
					$code += "WRITE\nPOP\n";
				}
			}
		}
	| whileStat
		{
			$code = $whileStat.code;
		}
	| ifElseStat
		{
			$code = $ifElseStat.code;
		}
	| FININSTRUCTION
		{
			$code = "";
		}
	;

assignation returns [String code]
	: IDENTIFIANT '=' expr
		{
			$code = new String();
			// a = 5;
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
			if( at != null )
			{
				// push value on stack
				$code += $expr.code;
				String addr = "" + at.adresse;
				// use storeg to replace the value in the stack
				$code += "STOREG " + addr + "\n";
			}
		}	
	;

whileStat returns [String code]
	@init
		{
			// intialize cur label once
			int cur_label = nextLabel();
			$code = new String();
		}
	: WHILE '(' logical_expression ')' NEWLINE* block
		{
			$code += "LABEL " + cur_label + "\n";
			$code += $logical_expression.code;
			int end_label = nextLabel();
			// jump if [sp-1] = 1 else pc+2
			$code += "JUMPF " + end_label + "\n";
			$code += $block.code;
			// jump to previous label
			$code += "JUMP " + cur_label + "\n";
			$code += "LABEL " + end_label + "\n";
		}
	;

ifElseStat returns [String code]
	@init
		{
			// if label to execute if condition
			int if_label = nextLabel();
			// else label to execute else condition
			int else_label = nextLabel();
			$code = new String();
		}
	@after
		{
			// end label to come to end directly
			int end_label = nextLabel();
			$code += "LABEL " + end_label + "\n";
		}
	: (IF '(' logical_expression ')' NEWLINE* block
		{
			// if statement
			$code += $logical_expression.code;
			// jump into else statement code if the logical expression evaluates to false (top of stack == 0)
			// JUMPF increments pc + 2 if top of stack != 0 otherwise executes normally
			$code += "JUMPF " + else_label + "\n";
			// jump into if label if evaluated to true
			$code += "JUMP " + if_label + "\n";
			// if label starts here
			$code += "LABEL " + if_label + "\n";
			$code += $block.code;
			// if we reach here then we don't execute the else and go to the end
			$code += "JUMP " + (else_label + 1) + "\n";
		})
	  (ELSE NEWLINE* block
		{
			// else statement
			// else label starts here
			$code += "LABEL " + else_label + "\n";
			$code += $block.code;
			// if we reach here then we go to the end label
			$code += "JUMP " + (else_label + 1) + "\n";
		})
	;

logical_expression returns [String code]
	@init
	{
		$code = new String();
	}
	: (condition
		{
			$code += $condition.code;
		}) (op=(OR | AND) condition
		{
			$code += $condition.code;
			if( $op.type == AND )
			{
				// if AND, then multiply whatever is on the stack
				$code += "MUL\n";
			}
			else if( $op.type == OR )
			{
				// if OR then add whatever is on the stack
				$code += "ADD\n";
			}
		})*
	;

condition returns [String code]
	: a=expr op=(EQUAL | DIFFERENT | SUP | SUP_EQ | INF | INF_EQ) b=expr
		{
			if( $a.type == $b.type )
			{
				$code = $a.code + $b.code + evalcondition($op.type, $a.type);
			}
			else
			{
				System.err.println("Error: comparison between two different types: " + $a.type + " " + $b.type);
				System.exit(0);
			}
		}
	| 'true'
		{
			$code = "PUSHI 1\n";
		}
	| 'false'
		{
			$code = "PUSHI 0\n";
		}
	;

block returns [String code]
	@init
		{
			$code = new String();
		}
	: '{' (instruction
		{
			$code += $instruction.code;
		})* '}' NEWLINE*
	| '{' (decl
		{
			$code += $decl.code;
		})* '}' NEWLINE*
	;

expr returns [String code, String type, int result]
	: a=expr op=('*' | '/') b=expr
		{
			if( $a.type.equals("int") && $b.type.equals("int") )
			{
				$code = $a.code + $b.code + makeinstruction($op.type, "int");
				$result = evalexpr($a.result, $op.type, $b.result);
			}
			else if( $a.type.equals("float") && $b.type.equals("float") )
			{
				$code = $a.code + $b.code + makeinstruction($op.type, "float");
			}
			else
			{
				System.err.println("Error: Operands must be the same type");
				System.err.println("Exiting");
				System.exit(0);
			}
		}
	| a=expr op=('+' | '-') b=expr
		{
			if( $a.type.equals("int") && $b.type.equals("int") )
			{
				$code = $a.code + $b.code + makeinstruction($op.type, "int");
				$result = evalexpr($a.result, $op.type, $b.result);
			}
			else if( $a.type.equals("float") && $b.type.equals("float") )
			{
				$code = $a.code + $b.code + makeinstruction($op.type, "float");
			}
			else
			{
				System.err.println("Error: Operands must be the same type");
				System.err.println("Exiting");
				System.exit(0);
			}
		}
	| '-' ENTIER
		{
			$type = "int";
			int temp = -1 * $ENTIER.int;
			$code = "PUSHI " + temp + "\n";
			$result = -1 * $ENTIER.int;
		}
	| ENTIER
		{
			$type = "int";
			$code = "PUSHI " + $ENTIER.int + "\n";
			$result = $ENTIER.int;
		}
	| '-' FLOTTANT
		{
			$type = "float";
			float temp = -1.0f * Float.parseFloat($FLOTTANT.text);
			$code = "PUSHF " + temp + "\n";
		}
	| FLOTTANT
		{
			$type = "float";
			$code = "PUSHF " + Float.parseFloat($FLOTTANT.text) + "\n";
		}
	| IDENTIFIANT '(' args ')'
		{
			// f(), g(), h(arg1, arg2)
			// save space on stack for return value
			$code = "PUSHI 0\n";
			$code += $args.code;
			// find address of function
			int func_addr = tablesSymboles.getFonction($IDENTIFIANT.text).adresse;
			$code += "CALL " + func_addr + "\n";
			
			// remove arguments from stack
			for( int i = 0; i < $args.size; ++i )
			{
				$code += "POP\n";
			}
		}
	| IDENTIFIANT
		{
			// a
			$code = new String();
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
			if( at != null )
			{
				int addr = at.adresse;
				if( at.type.equals("int") )
				{
					$type = "int";
					$code += "PUSHL " + addr + "\n";
				}
				else
				{
					$type = "float";
					$code += "PUSHL " + addr + "\n";
					$code += "PUSHL " + (addr + 1) + "\n";
				}
			}
		}
	| '(' expr ')'
		{
			$type = $expr.type;
			$code = $expr.code;
			$result = $expr.result;
		}
	;

// lexer
// operations
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';

// conditions
EQUAL: '==';
DIFFERENT: '!=';
SUP: '>';
SUP_EQ: '>=';
INF: '<';
INF_EQ: '<=';

// logical operations
AND: 'and';
OR: 'or';
NOT: 'not';

// other
FININSTRUCTION: ';';
READLN: 'readln';
PRINTLN: 'println';

IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
TYPE: 'int' | 'float';
IDENTIFIANT: [a-zA-Z]+;
ENTIER: [0-9]+;
FLOTTANT: ([0-9]+([.][0-9]*)?|[.][0-9]+);			// 1.5 or 15. or .553
NEWLINE: '\r'? '\n' -> skip;
UNMATCH: . -> skip;








