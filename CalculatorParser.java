// Generated from Calculator.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, MUL=9, 
		DIV=10, ADD=11, SUB=12, EQUAL=13, DIFFERENT=14, SUP=15, SUP_EQ=16, INF=17, 
		INF_EQ=18, AND=19, OR=20, NOT=21, FININSTRUCTION=22, READLN=23, PRINTLN=24, 
		IF=25, ELSE=26, WHILE=27, RETURN=28, TYPE=29, IDENTIFIANT=30, ENTIER=31, 
		FLOTTANT=32, NEWLINE=33, UNMATCH=34;
	public static final int
		RULE_calcul = 0, RULE_decl = 1, RULE_fonction = 2, RULE_params = 3, RULE_args = 4, 
		RULE_instruction = 5, RULE_assignation = 6, RULE_whileStat = 7, RULE_ifElseStat = 8, 
		RULE_logical_expression = 9, RULE_condition = 10, RULE_block = 11, RULE_expr = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "decl", "fonction", "params", "args", "instruction", "assignation", 
			"whileStat", "ifElseStat", "logical_expression", "condition", "block", 
			"expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "','", "'true'", "'false'", "'{'", "'}'", 
			"'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", 
			"'and'", "'or'", "'not'", "';'", "'readln'", "'println'", "'if'", "'else'", 
			"'while'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "MUL", "DIV", "ADD", 
			"SUB", "EQUAL", "DIFFERENT", "SUP", "SUP_EQ", "INF", "INF_EQ", "AND", 
			"OR", "NOT", "FININSTRUCTION", "READLN", "PRINTLN", "IF", "ELSE", "WHILE", 
			"RETURN", "TYPE", "IDENTIFIANT", "ENTIER", "FLOTTANT", "NEWLINE", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public CalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculatorParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculatorParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calcul);

					((CalculContext)_localctx).code =  new String();
				
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					((CalculContext)_localctx).decl = decl();

								// declaration
								_localctx.code += ((CalculContext)_localctx).decl.code;
							
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}

						int entry = nextLabel();
						_localctx.code += "JUMP " + entry + "\n";
					
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					match(NEWLINE);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}

						_localctx.code += "";
					
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(42);
				((CalculContext)_localctx).fonction = fonction();

					  		_localctx.code += ((CalculContext)_localctx).fonction.code;
					  	
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(50);
				match(NEWLINE);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

				  		_localctx.code += "";
				  	

				  		_localctx.code += "LABEL " + entry + "\n";
				  	
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SUB) | (1L << FININSTRUCTION) | (1L << READLN) | (1L << PRINTLN) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOTTANT))) != 0)) {
				{
				{
				setState(58);
				((CalculContext)_localctx).instruction = instruction();

				   			// instruction, eg. x = 5; 7 * 4;
				   			_localctx.code += ((CalculContext)_localctx).instruction.code;
				   		
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);

			   			System.out.print(_localctx.code);
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
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExprContext expr;
		public TerminalNode TYPE() { return getToken(CalculatorParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculatorParser.IDENTIFIANT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FININSTRUCTION() { return getToken(CalculatorParser.FININSTRUCTION, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(67);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(68);
				match(T__0);
				setState(69);
				((DeclContext)_localctx).expr = expr(0);
				setState(70);
				match(FININSTRUCTION);

							if( (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("int") )
							{
								// int a = 5;
								// store the variable in the symbol table
								// push it on the stack
								// increase variable count
								incvarg_count();
								
								tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
								((DeclContext)_localctx).code =  "PUSHI 0\n";
								_localctx.code += ((DeclContext)_localctx).expr.code;
								// get address of variable
								AdresseType at = tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
								_localctx.code += "STOREG " + at.adresse + "\n";
							}
							else if( (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("float") )
							{
								tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
								((DeclContext)_localctx).code =  ((DeclContext)_localctx).expr.code;
								incfloatg_count();
							}
							else
							{
								try
								{
									throw new Exception("Unidentified type: " + (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
								}
								catch( Exception e )
								{
									e.printStackTrace();
									System.exit(-1);
								}
							}
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(74);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(75);
				match(FININSTRUCTION);

							incvarg_count();
							((DeclContext)_localctx).code =  new String();
							// int a;
							// store the variable in the symbol table
							// push it on the stack
							tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
							_localctx.code += "PUSHI 0\n";
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ParamsContext params;
		public BlockContext block;
		public TerminalNode TYPE() { return getToken(CalculatorParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculatorParser.IDENTIFIANT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fonction);

					int params_size = 0;
					((FonctionContext)_localctx).code =  new String();
					tablesSymboles.newTableLocale();
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			((FonctionContext)_localctx).TYPE = match(TYPE);
			setState(80);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

						// start by putting the function in the table of functions
						int func_label = nextLabel();
						// function name, label number, function type
						tablesSymboles.nouvelleFonction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), func_label, (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
						// add label to the function
						_localctx.code += "LABEL " + func_label + "\n";
					
			setState(82);
			match(T__1);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(83);
				((FonctionContext)_localctx).params = params();

					  			_localctx.code += ((FonctionContext)_localctx).params.code;
					  			params_size = ((FonctionContext)_localctx).params.size;
					  		
				}
			}

			setState(88);
			match(T__2);
			setState(89);
			((FonctionContext)_localctx).block = block();

						// function body
						_localctx.code += ((FonctionContext)_localctx).block.code;
						
						// position of return value in stack, -3 if there are no parameters
						int ret_val_pos = -3;
						if( params_size > 0 )
						{
							ret_val_pos -= params_size;
						}
						
						_localctx.code += "STOREL " + ret_val_pos + "\n";
						_localctx.code += "RETURN\nRETURN\n";
					
			}
			_ctx.stop = _input.LT(-1);

						tablesSymboles.dropTableLocale();
					
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public String code;
		public int size;
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculatorParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculatorParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculatorParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculatorParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);

					((ParamsContext)_localctx).code =  new String();
					((ParamsContext)_localctx).size =  0;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(93);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

						// java code to define parameters
						// eg. int x, float y
						
						// add parameter to the local table
						tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
						_localctx.size += 1;
					
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(95);
				match(T__3);
				setState(96);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(97);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

					  		// java code to define more parameters
					  		System.out.println("more params found");
							// add parameter to the local table
							tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
					  		_localctx.size += 1;
					  	
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_args);

					((ArgsContext)_localctx).code =  new String();
					((ArgsContext)_localctx).size =  0;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SUB) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOTTANT))) != 0)) {
				{
				setState(104);
				((ArgsContext)_localctx).expr = expr(0);

							// java code for first expression for arg1
							_localctx.code += ((ArgsContext)_localctx).expr.code;
							_localctx.size += 1;
						
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(106);
					match(T__3);
					setState(107);
					((ArgsContext)_localctx).expr = expr(0);

						  		// java code for the next expression - argi
								_localctx.code += ((ArgsContext)_localctx).expr.code;
								_localctx.size += 1;
						  	
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExprContext expr;
		public AssignationContext assignation;
		public Token IDENTIFIANT;
		public WhileStatContext whileStat;
		public IfElseStatContext ifElseStat;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FININSTRUCTION() { return getToken(CalculatorParser.FININSTRUCTION, 0); }
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CalculatorParser.RETURN, 0); }
		public TerminalNode READLN() { return getToken(CalculatorParser.READLN, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculatorParser.IDENTIFIANT, 0); }
		public TerminalNode PRINTLN() { return getToken(CalculatorParser.PRINTLN, 0); }
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public IfElseStatContext ifElseStat() {
			return getRuleContext(IfElseStatContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instruction);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				((InstructionContext)_localctx).expr = expr(0);
				setState(118);
				match(FININSTRUCTION);

							((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code;
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((InstructionContext)_localctx).assignation = assignation();
				setState(122);
				match(FININSTRUCTION);

							((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(RETURN);
				setState(126);
				((InstructionContext)_localctx).expr = expr(0);
				setState(127);
				match(FININSTRUCTION);

							// return expression
							((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code;
						
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(READLN);
				setState(131);
				match(T__1);
				setState(132);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(133);
				match(T__2);
				setState(134);
				match(FININSTRUCTION);

							// get address of identifiant
							((InstructionContext)_localctx).code =  "";
							AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
							if( at != null )
							{
								String addr = "" + at.adresse;
								// read input from the terminal
								_localctx.code += "READ\n";
								// store the input in address
								_localctx.code += "STOREG " + addr + "\n";
							}
						
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				match(PRINTLN);
				setState(137);
				match(T__1);
				setState(138);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(139);
				match(T__2);
				setState(140);
				match(FININSTRUCTION);

							// get address of identifiant
							// PUSHG [addr]
							// print it with WRITE
							((InstructionContext)_localctx).code =  "";
							AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
							if( at != null )
							{
								int addr = at.adresse;
								// write the variable and pop it immediately after return
								if( at.type.equals("float") )
								{
									// printing a float, use WRITEF
									// requires two pushg apparently
									_localctx.code += "PUSHG " + addr + "\n";
									_localctx.code += "PUSHG " + (addr + 1) + "\n";
									_localctx.code += "WRITEF\nPOPF\n";
								}
								else if( at.type.equals("int") )
								{
									// printing an int, use WRITE
									_localctx.code += "PUSHG " + addr + "\n";
									_localctx.code += "WRITE\nPOP\n";
								}
							}
						
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				((InstructionContext)_localctx).whileStat = whileStat();

							((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).whileStat.code;
						
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(145);
				((InstructionContext)_localctx).ifElseStat = ifElseStat();

							((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).ifElseStat.code;
						
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148);
				match(FININSTRUCTION);

							((InstructionContext)_localctx).code =  "";
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExprContext expr;
		public TerminalNode IDENTIFIANT() { return getToken(CalculatorParser.IDENTIFIANT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(153);
			match(T__0);
			setState(154);
			((AssignationContext)_localctx).expr = expr(0);

						((AssignationContext)_localctx).code =  new String();
						// a = 5;
						AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
						if( at != null )
						{
							// push value on stack
							_localctx.code += ((AssignationContext)_localctx).expr.code;
							String addr = "" + at.adresse;
							// use storeg to replace the value in the stack
							_localctx.code += "STOREG " + addr + "\n";
						}
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatContext extends ParserRuleContext {
		public String code;
		public Logical_expressionContext logical_expression;
		public BlockContext block;
		public TerminalNode WHILE() { return getToken(CalculatorParser.WHILE, 0); }
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculatorParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculatorParser.NEWLINE, i);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitWhileStat(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStat);

					// intialize cur label once
					int cur_label = nextLabel();
					((WhileStatContext)_localctx).code =  new String();
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(WHILE);
			setState(158);
			match(T__1);
			setState(159);
			((WhileStatContext)_localctx).logical_expression = logical_expression();
			setState(160);
			match(T__2);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(161);
				match(NEWLINE);
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			((WhileStatContext)_localctx).block = block();

						_localctx.code += "LABEL " + cur_label + "\n";
						_localctx.code += ((WhileStatContext)_localctx).logical_expression.code;
						int end_label = nextLabel();
						// jump if [sp-1] = 1 else pc+2
						_localctx.code += "JUMPF " + end_label + "\n";
						_localctx.code += ((WhileStatContext)_localctx).block.code;
						// jump to previous label
						_localctx.code += "JUMP " + cur_label + "\n";
						_localctx.code += "LABEL " + end_label + "\n";
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatContext extends ParserRuleContext {
		public String code;
		public Logical_expressionContext logical_expression;
		public BlockContext block;
		public TerminalNode IF() { return getToken(CalculatorParser.IF, 0); }
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CalculatorParser.ELSE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CalculatorParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculatorParser.NEWLINE, i);
		}
		public IfElseStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterIfElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitIfElseStat(this);
		}
	}

	public final IfElseStatContext ifElseStat() throws RecognitionException {
		IfElseStatContext _localctx = new IfElseStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifElseStat);

					// if label to execute if condition
					int if_label = nextLabel();
					// else label to execute else condition
					int else_label = nextLabel();
					((IfElseStatContext)_localctx).code =  new String();
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(170);
			match(IF);
			setState(171);
			match(T__1);
			setState(172);
			((IfElseStatContext)_localctx).logical_expression = logical_expression();
			setState(173);
			match(T__2);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(174);
				match(NEWLINE);
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			((IfElseStatContext)_localctx).block = block();

						// if statement
						_localctx.code += ((IfElseStatContext)_localctx).logical_expression.code;
						// jump into else statement code if the logical expression evaluates to false (top of stack == 0)
						// JUMPF increments pc + 2 if top of stack != 0 otherwise executes normally
						_localctx.code += "JUMPF " + else_label + "\n";
						// jump into if label if evaluated to true
						_localctx.code += "JUMP " + if_label + "\n";
						// if label starts here
						_localctx.code += "LABEL " + if_label + "\n";
						_localctx.code += ((IfElseStatContext)_localctx).block.code;
						// if we reach here then we don't execute the else and go to the end
						_localctx.code += "JUMP " + (else_label + 1) + "\n";
					
			}
			{
			setState(183);
			match(ELSE);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(184);
				match(NEWLINE);
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			((IfElseStatContext)_localctx).block = block();

						// else statement
						// else label starts here
						_localctx.code += "LABEL " + else_label + "\n";
						_localctx.code += ((IfElseStatContext)_localctx).block.code;
						// if we reach here then we go to the end label
						_localctx.code += "JUMP " + (else_label + 1) + "\n";
					
			}
			}
			_ctx.stop = _input.LT(-1);

						// end label to come to end directly
						int end_label = nextLabel();
						_localctx.code += "LABEL " + end_label + "\n";
					
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_expressionContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public Token op;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CalculatorParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CalculatorParser.OR, i);
		}
		public List<TerminalNode> AND() { return getTokens(CalculatorParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CalculatorParser.AND, i);
		}
		public Logical_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterLogical_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitLogical_expression(this);
		}
	}

	public final Logical_expressionContext logical_expression() throws RecognitionException {
		Logical_expressionContext _localctx = new Logical_expressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logical_expression);

				((Logical_expressionContext)_localctx).code =  new String();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(193);
			((Logical_expressionContext)_localctx).condition = condition();

						_localctx.code += ((Logical_expressionContext)_localctx).condition.code;
					
			}
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(196);
				((Logical_expressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
					((Logical_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(197);
				((Logical_expressionContext)_localctx).condition = condition();

							_localctx.code += ((Logical_expressionContext)_localctx).condition.code;
							if( (((Logical_expressionContext)_localctx).op!=null?((Logical_expressionContext)_localctx).op.getType():0) == AND )
							{
								// if AND, then multiply whatever is on the stack
								_localctx.code += "MUL\n";
							}
							else if( (((Logical_expressionContext)_localctx).op!=null?((Logical_expressionContext)_localctx).op.getType():0) == OR )
							{
								// if OR then add whatever is on the stack
								_localctx.code += "ADD\n";
							}
						
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ExprContext a;
		public Token op;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CalculatorParser.EQUAL, 0); }
		public TerminalNode DIFFERENT() { return getToken(CalculatorParser.DIFFERENT, 0); }
		public TerminalNode SUP() { return getToken(CalculatorParser.SUP, 0); }
		public TerminalNode SUP_EQ() { return getToken(CalculatorParser.SUP_EQ, 0); }
		public TerminalNode INF() { return getToken(CalculatorParser.INF, 0); }
		public TerminalNode INF_EQ() { return getToken(CalculatorParser.INF_EQ, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condition);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case SUB:
			case IDENTIFIANT:
			case ENTIER:
			case FLOTTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				((ConditionContext)_localctx).a = expr(0);
				setState(206);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << DIFFERENT) | (1L << SUP) | (1L << SUP_EQ) | (1L << INF) | (1L << INF_EQ))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
				((ConditionContext)_localctx).b = expr(0);

							if( ((ConditionContext)_localctx).a.type == ((ConditionContext)_localctx).b.type )
							{
								((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + evalcondition((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getType():0), ((ConditionContext)_localctx).a.type);
							}
							else
							{
								System.err.println("Error: comparison between two different types: " + ((ConditionContext)_localctx).a.type + " " + ((ConditionContext)_localctx).b.type);
								System.exit(0);
							}
						
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(T__4);

							((ConditionContext)_localctx).code =  "PUSHI 1\n";
						
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(T__5);

							((ConditionContext)_localctx).code =  "PUSHI 0\n";
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public DeclContext decl;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculatorParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculatorParser.NEWLINE, i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);

					((BlockContext)_localctx).code =  new String();
				
		int _la;
		try {
			int _alt;
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(T__6);
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SUB) | (1L << FININSTRUCTION) | (1L << READLN) | (1L << PRINTLN) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOTTANT))) != 0)) {
					{
					{
					setState(217);
					((BlockContext)_localctx).instruction = instruction();

								_localctx.code += ((BlockContext)_localctx).instruction.code;
							
					}
					}
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(225);
				match(T__7);
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(226);
						match(NEWLINE);
						}
						} 
					}
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				match(T__6);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE) {
					{
					{
					setState(233);
					((BlockContext)_localctx).decl = decl();

								_localctx.code += ((BlockContext)_localctx).decl.code;
							
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(241);
				match(T__7);
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(242);
						match(NEWLINE);
						}
						} 
					}
					setState(247);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public String code;
		public String type;
		public int result;
		public ExprContext a;
		public Token ENTIER;
		public Token FLOTTANT;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public ExprContext expr;
		public Token op;
		public ExprContext b;
		public TerminalNode SUB() { return getToken(CalculatorParser.SUB, 0); }
		public TerminalNode ENTIER() { return getToken(CalculatorParser.ENTIER, 0); }
		public TerminalNode FLOTTANT() { return getToken(CalculatorParser.FLOTTANT, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculatorParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(CalculatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(CalculatorParser.ADD, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(251);
				match(SUB);
				setState(252);
				((ExprContext)_localctx).ENTIER = match(ENTIER);

							((ExprContext)_localctx).type =  "int";
							int temp = -1 * (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0);
							((ExprContext)_localctx).code =  "PUSHI " + temp + "\n";
							((ExprContext)_localctx).result =  -1 * (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0);
						
				}
				break;
			case 2:
				{
				setState(254);
				((ExprContext)_localctx).ENTIER = match(ENTIER);

							((ExprContext)_localctx).type =  "int";
							((ExprContext)_localctx).code =  "PUSHI " + (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0) + "\n";
							((ExprContext)_localctx).result =  (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0);
						
				}
				break;
			case 3:
				{
				setState(256);
				match(SUB);
				setState(257);
				((ExprContext)_localctx).FLOTTANT = match(FLOTTANT);

							((ExprContext)_localctx).type =  "float";
							float temp = -1.0f * Float.parseFloat((((ExprContext)_localctx).FLOTTANT!=null?((ExprContext)_localctx).FLOTTANT.getText():null));
							((ExprContext)_localctx).code =  "PUSHF " + temp + "\n";
						
				}
				break;
			case 4:
				{
				setState(259);
				((ExprContext)_localctx).FLOTTANT = match(FLOTTANT);

							((ExprContext)_localctx).type =  "float";
							((ExprContext)_localctx).code =  "PUSHF " + Float.parseFloat((((ExprContext)_localctx).FLOTTANT!=null?((ExprContext)_localctx).FLOTTANT.getText():null)) + "\n";
						
				}
				break;
			case 5:
				{
				setState(261);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(262);
				match(T__1);
				setState(263);
				((ExprContext)_localctx).args = args();
				setState(264);
				match(T__2);

							// f(), g(), h(arg1, arg2)
							// save space on stack for return value
							((ExprContext)_localctx).code =  "PUSHI 0\n";
							_localctx.code += ((ExprContext)_localctx).args.code;
							// find address of function
							int func_addr = tablesSymboles.getFonction((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null)).adresse;
							_localctx.code += "CALL " + func_addr + "\n";
							
							// remove arguments from stack
							for( int i = 0; i < ((ExprContext)_localctx).args.size; ++i )
							{
								_localctx.code += "POP\n";
							}
						
				}
				break;
			case 6:
				{
				setState(267);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

							// a
							((ExprContext)_localctx).code =  new String();
							AdresseType at = tablesSymboles.getAdresseType((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null));
							if( at != null )
							{
								int addr = at.adresse;
								if( at.type.equals("int") )
								{
									((ExprContext)_localctx).type =  "int";
									_localctx.code += "PUSHL " + addr + "\n";
								}
								else
								{
									((ExprContext)_localctx).type =  "float";
									_localctx.code += "PUSHL " + addr + "\n";
									_localctx.code += "PUSHL " + (addr + 1) + "\n";
								}
							}
						
				}
				break;
			case 7:
				{
				setState(269);
				match(T__1);
				setState(270);
				((ExprContext)_localctx).expr = expr(0);
				setState(271);
				match(T__2);

							((ExprContext)_localctx).type =  ((ExprContext)_localctx).expr.type;
							((ExprContext)_localctx).code =  ((ExprContext)_localctx).expr.code;
							((ExprContext)_localctx).result =  ((ExprContext)_localctx).expr.result;
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(286);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(277);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(278);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(10);

						          			if( ((ExprContext)_localctx).a.type.equals("int") && ((ExprContext)_localctx).b.type.equals("int") )
						          			{
						          				((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code + ((ExprContext)_localctx).b.code + makeinstruction((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0), "int");
						          				((ExprContext)_localctx).result =  evalexpr(((ExprContext)_localctx).a.result, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0), ((ExprContext)_localctx).b.result);
						          			}
						          			else if( ((ExprContext)_localctx).a.type.equals("float") && ((ExprContext)_localctx).b.type.equals("float") )
						          			{
						          				((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code + ((ExprContext)_localctx).b.code + makeinstruction((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0), "float");
						          			}
						          			else
						          			{
						          				System.err.println("Error: Operands must be the same type");
						          				System.err.println("Exiting");
						          				System.exit(0);
						          			}
						          		
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(281);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(282);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(283);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(9);

						          			if( ((ExprContext)_localctx).a.type.equals("int") && ((ExprContext)_localctx).b.type.equals("int") )
						          			{
						          				((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code + ((ExprContext)_localctx).b.code + makeinstruction((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0), "int");
						          				((ExprContext)_localctx).result =  evalexpr(((ExprContext)_localctx).a.result, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0), ((ExprContext)_localctx).b.result);
						          			}
						          			else if( ((ExprContext)_localctx).a.type.equals("float") && ((ExprContext)_localctx).b.type.equals("float") )
						          			{
						          				((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code + ((ExprContext)_localctx).b.code + makeinstruction((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0), "float");
						          			}
						          			else
						          			{
						          				System.err.println("Error: Operands must be the same type");
						          				System.err.println("Exiting");
						          				System.exit(0);
						          			}
						          		
						}
						break;
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0126\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\2"+
		"\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\2\3\2\7\2\60\n\2\f\2\16\2\63\13"+
		"\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\2\3\2\3\2\7\2@\n\2\f\2\16\2"+
		"C\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4Y\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5f\n\5\f\5\16\5i\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6q\n\6\f\6\16\6t"+
		"\13\6\5\6v\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0099\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t\u00a5"+
		"\n\t\f\t\16\t\u00a8\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u00b2\n\n"+
		"\f\n\16\n\u00b5\13\n\3\n\3\n\3\n\3\n\3\n\7\n\u00bc\n\n\f\n\16\n\u00bf"+
		"\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00cb\n\13\f"+
		"\13\16\13\u00ce\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d9\n"+
		"\f\3\r\3\r\3\r\3\r\7\r\u00df\n\r\f\r\16\r\u00e2\13\r\3\r\3\r\7\r\u00e6"+
		"\n\r\f\r\16\r\u00e9\13\r\3\r\3\r\3\r\3\r\7\r\u00ef\n\r\f\r\16\r\u00f2"+
		"\13\r\3\r\3\r\7\r\u00f6\n\r\f\r\16\r\u00f9\13\r\5\r\u00fb\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0115\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0121\n\16\f\16\16\16\u0124\13"+
		"\16\3\16\2\3\32\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\3\2\25\26\3\2"+
		"\17\24\3\2\13\f\3\2\r\16\2\u013c\2!\3\2\2\2\4O\3\2\2\2\6Q\3\2\2\2\b^\3"+
		"\2\2\2\nu\3\2\2\2\f\u0098\3\2\2\2\16\u009a\3\2\2\2\20\u009f\3\2\2\2\22"+
		"\u00ac\3\2\2\2\24\u00c3\3\2\2\2\26\u00d8\3\2\2\2\30\u00fa\3\2\2\2\32\u0114"+
		"\3\2\2\2\34\35\5\4\3\2\35\36\b\2\1\2\36 \3\2\2\2\37\34\3\2\2\2 #\3\2\2"+
		"\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$(\b\2\1\2%\'\7#\2\2&%\3"+
		"\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+\61\b\2\1\2"+
		",-\5\6\4\2-.\b\2\1\2.\60\3\2\2\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\62\67\3\2\2\2\63\61\3\2\2\2\64\66\7#\2\2\65\64\3\2\2\2\66"+
		"9\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\b\2\1\2;A"+
		"\b\2\1\2<=\5\f\7\2=>\b\2\1\2>@\3\2\2\2?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2A"+
		"B\3\2\2\2B\3\3\2\2\2CA\3\2\2\2DE\7\37\2\2EF\7 \2\2FG\7\3\2\2GH\5\32\16"+
		"\2HI\7\30\2\2IJ\b\3\1\2JP\3\2\2\2KL\7\37\2\2LM\7 \2\2MN\7\30\2\2NP\b\3"+
		"\1\2OD\3\2\2\2OK\3\2\2\2P\5\3\2\2\2QR\7\37\2\2RS\7 \2\2ST\b\4\1\2TX\7"+
		"\4\2\2UV\5\b\5\2VW\b\4\1\2WY\3\2\2\2XU\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7"+
		"\5\2\2[\\\5\30\r\2\\]\b\4\1\2]\7\3\2\2\2^_\7\37\2\2_`\7 \2\2`g\b\5\1\2"+
		"ab\7\6\2\2bc\7\37\2\2cd\7 \2\2df\b\5\1\2ea\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2h\t\3\2\2\2ig\3\2\2\2jk\5\32\16\2kr\b\6\1\2lm\7\6\2\2mn\5\32"+
		"\16\2no\b\6\1\2oq\3\2\2\2pl\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sv\3"+
		"\2\2\2tr\3\2\2\2uj\3\2\2\2uv\3\2\2\2v\13\3\2\2\2wx\5\32\16\2xy\7\30\2"+
		"\2yz\b\7\1\2z\u0099\3\2\2\2{|\5\16\b\2|}\7\30\2\2}~\b\7\1\2~\u0099\3\2"+
		"\2\2\177\u0080\7\36\2\2\u0080\u0081\5\32\16\2\u0081\u0082\7\30\2\2\u0082"+
		"\u0083\b\7\1\2\u0083\u0099\3\2\2\2\u0084\u0085\7\31\2\2\u0085\u0086\7"+
		"\4\2\2\u0086\u0087\7 \2\2\u0087\u0088\7\5\2\2\u0088\u0089\7\30\2\2\u0089"+
		"\u0099\b\7\1\2\u008a\u008b\7\32\2\2\u008b\u008c\7\4\2\2\u008c\u008d\7"+
		" \2\2\u008d\u008e\7\5\2\2\u008e\u008f\7\30\2\2\u008f\u0099\b\7\1\2\u0090"+
		"\u0091\5\20\t\2\u0091\u0092\b\7\1\2\u0092\u0099\3\2\2\2\u0093\u0094\5"+
		"\22\n\2\u0094\u0095\b\7\1\2\u0095\u0099\3\2\2\2\u0096\u0097\7\30\2\2\u0097"+
		"\u0099\b\7\1\2\u0098w\3\2\2\2\u0098{\3\2\2\2\u0098\177\3\2\2\2\u0098\u0084"+
		"\3\2\2\2\u0098\u008a\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0093\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\r\3\2\2\2\u009a\u009b\7 \2\2\u009b\u009c\7\3\2\2"+
		"\u009c\u009d\5\32\16\2\u009d\u009e\b\b\1\2\u009e\17\3\2\2\2\u009f\u00a0"+
		"\7\35\2\2\u00a0\u00a1\7\4\2\2\u00a1\u00a2\5\24\13\2\u00a2\u00a6\7\5\2"+
		"\2\u00a3\u00a5\7#\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\5\30\r\2\u00aa\u00ab\b\t\1\2\u00ab\21\3\2\2\2\u00ac\u00ad\7\33"+
		"\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00af\5\24\13\2\u00af\u00b3\7\5\2\2\u00b0"+
		"\u00b2\7#\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6"+
		"\u00b7\5\30\r\2\u00b7\u00b8\b\n\1\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\7"+
		"\34\2\2\u00ba\u00bc\7#\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c1\5\30\r\2\u00c1\u00c2\b\n\1\2\u00c2\23\3\2\2\2\u00c3\u00c4"+
		"\5\26\f\2\u00c4\u00c5\b\13\1\2\u00c5\u00cc\3\2\2\2\u00c6\u00c7\t\2\2\2"+
		"\u00c7\u00c8\5\26\f\2\u00c8\u00c9\b\13\1\2\u00c9\u00cb\3\2\2\2\u00ca\u00c6"+
		"\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\25\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\5\32\16\2\u00d0\u00d1\t\3"+
		"\2\2\u00d1\u00d2\5\32\16\2\u00d2\u00d3\b\f\1\2\u00d3\u00d9\3\2\2\2\u00d4"+
		"\u00d5\7\7\2\2\u00d5\u00d9\b\f\1\2\u00d6\u00d7\7\b\2\2\u00d7\u00d9\b\f"+
		"\1\2\u00d8\u00cf\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\27\3\2\2\2\u00da\u00e0\7\t\2\2\u00db\u00dc\5\f\7\2\u00dc\u00dd\b\r\1"+
		"\2\u00dd\u00df\3\2\2\2\u00de\u00db\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e7\7\n\2\2\u00e4\u00e6\7#\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00fb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00f0\7\t\2\2\u00eb\u00ec\5\4\3\2\u00ec\u00ed\b\r"+
		"\1\2\u00ed\u00ef\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2"+
		"\2\2\u00f3\u00f7\7\n\2\2\u00f4\u00f6\7#\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fb\3\2"+
		"\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00da\3\2\2\2\u00fa\u00ea\3\2\2\2\u00fb"+
		"\31\3\2\2\2\u00fc\u00fd\b\16\1\2\u00fd\u00fe\7\16\2\2\u00fe\u00ff\7!\2"+
		"\2\u00ff\u0115\b\16\1\2\u0100\u0101\7!\2\2\u0101\u0115\b\16\1\2\u0102"+
		"\u0103\7\16\2\2\u0103\u0104\7\"\2\2\u0104\u0115\b\16\1\2\u0105\u0106\7"+
		"\"\2\2\u0106\u0115\b\16\1\2\u0107\u0108\7 \2\2\u0108\u0109\7\4\2\2\u0109"+
		"\u010a\5\n\6\2\u010a\u010b\7\5\2\2\u010b\u010c\b\16\1\2\u010c\u0115\3"+
		"\2\2\2\u010d\u010e\7 \2\2\u010e\u0115\b\16\1\2\u010f\u0110\7\4\2\2\u0110"+
		"\u0111\5\32\16\2\u0111\u0112\7\5\2\2\u0112\u0113\b\16\1\2\u0113\u0115"+
		"\3\2\2\2\u0114\u00fc\3\2\2\2\u0114\u0100\3\2\2\2\u0114\u0102\3\2\2\2\u0114"+
		"\u0105\3\2\2\2\u0114\u0107\3\2\2\2\u0114\u010d\3\2\2\2\u0114\u010f\3\2"+
		"\2\2\u0115\u0122\3\2\2\2\u0116\u0117\f\13\2\2\u0117\u0118\t\4\2\2\u0118"+
		"\u0119\5\32\16\f\u0119\u011a\b\16\1\2\u011a\u0121\3\2\2\2\u011b\u011c"+
		"\f\n\2\2\u011c\u011d\t\5\2\2\u011d\u011e\5\32\16\13\u011e\u011f\b\16\1"+
		"\2\u011f\u0121\3\2\2\2\u0120\u0116\3\2\2\2\u0120\u011b\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\33\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\32!(\61\67AOXgru\u0098\u00a6\u00b3\u00bd\u00cc\u00d8\u00e0"+
		"\u00e7\u00f0\u00f7\u00fa\u0114\u0120\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}