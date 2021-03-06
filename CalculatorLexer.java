// Generated from Calculator.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "MUL", 
			"DIV", "ADD", "SUB", "EQUAL", "DIFFERENT", "SUP", "SUP_EQ", "INF", "INF_EQ", 
			"AND", "OR", "NOT", "FININSTRUCTION", "READLN", "PRINTLN", "IF", "ELSE", 
			"WHILE", "RETURN", "TYPE", "IDENTIFIANT", "ENTIER", "FLOTTANT", "NEWLINE", 
			"UNMATCH"
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


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00dc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u00b0\n\36\3\37\6\37\u00b3\n\37\r\37\16\37\u00b4"+
		"\3 \6 \u00b8\n \r \16 \u00b9\3!\6!\u00bd\n!\r!\16!\u00be\3!\3!\7!\u00c3"+
		"\n!\f!\16!\u00c6\13!\5!\u00c8\n!\3!\3!\6!\u00cc\n!\r!\16!\u00cd\5!\u00d0"+
		"\n!\3\"\5\"\u00d3\n\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\2\2$\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\5"+
		"\4\2C\\c|\3\2\62;\3\2\60\60\2\u00e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2"+
		"\13O\3\2\2\2\rT\3\2\2\2\17Z\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25`\3\2\2"+
		"\2\27b\3\2\2\2\31d\3\2\2\2\33f\3\2\2\2\35i\3\2\2\2\37l\3\2\2\2!n\3\2\2"+
		"\2#q\3\2\2\2%s\3\2\2\2\'v\3\2\2\2)z\3\2\2\2+}\3\2\2\2-\u0081\3\2\2\2/"+
		"\u0083\3\2\2\2\61\u008a\3\2\2\2\63\u0092\3\2\2\2\65\u0095\3\2\2\2\67\u009a"+
		"\3\2\2\29\u00a0\3\2\2\2;\u00af\3\2\2\2=\u00b2\3\2\2\2?\u00b7\3\2\2\2A"+
		"\u00cf\3\2\2\2C\u00d2\3\2\2\2E\u00d8\3\2\2\2GH\7?\2\2H\4\3\2\2\2IJ\7*"+
		"\2\2J\6\3\2\2\2KL\7+\2\2L\b\3\2\2\2MN\7.\2\2N\n\3\2\2\2OP\7v\2\2PQ\7t"+
		"\2\2QR\7w\2\2RS\7g\2\2S\f\3\2\2\2TU\7h\2\2UV\7c\2\2VW\7n\2\2WX\7u\2\2"+
		"XY\7g\2\2Y\16\3\2\2\2Z[\7}\2\2[\20\3\2\2\2\\]\7\177\2\2]\22\3\2\2\2^_"+
		"\7,\2\2_\24\3\2\2\2`a\7\61\2\2a\26\3\2\2\2bc\7-\2\2c\30\3\2\2\2de\7/\2"+
		"\2e\32\3\2\2\2fg\7?\2\2gh\7?\2\2h\34\3\2\2\2ij\7#\2\2jk\7?\2\2k\36\3\2"+
		"\2\2lm\7@\2\2m \3\2\2\2no\7@\2\2op\7?\2\2p\"\3\2\2\2qr\7>\2\2r$\3\2\2"+
		"\2st\7>\2\2tu\7?\2\2u&\3\2\2\2vw\7c\2\2wx\7p\2\2xy\7f\2\2y(\3\2\2\2z{"+
		"\7q\2\2{|\7t\2\2|*\3\2\2\2}~\7p\2\2~\177\7q\2\2\177\u0080\7v\2\2\u0080"+
		",\3\2\2\2\u0081\u0082\7=\2\2\u0082.\3\2\2\2\u0083\u0084\7t\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0086\7c\2\2\u0086\u0087\7f\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7p\2\2\u0089\60\3\2\2\2\u008a\u008b\7r\2\2\u008b\u008c\7t\2\2\u008c"+
		"\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\u0090\7n\2\2"+
		"\u0090\u0091\7p\2\2\u0091\62\3\2\2\2\u0092\u0093\7k\2\2\u0093\u0094\7"+
		"h\2\2\u0094\64\3\2\2\2\u0095\u0096\7g\2\2\u0096\u0097\7n\2\2\u0097\u0098"+
		"\7u\2\2\u0098\u0099\7g\2\2\u0099\66\3\2\2\2\u009a\u009b\7y\2\2\u009b\u009c"+
		"\7j\2\2\u009c\u009d\7k\2\2\u009d\u009e\7n\2\2\u009e\u009f\7g\2\2\u009f"+
		"8\3\2\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7v\2\2\u00a3"+
		"\u00a4\7w\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7p\2\2\u00a6:\3\2\2\2\u00a7"+
		"\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00b0\7v\2\2\u00aa\u00ab\7h\2\2"+
		"\u00ab\u00ac\7n\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7c\2\2\u00ae\u00b0"+
		"\7v\2\2\u00af\u00a7\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0<\3\2\2\2\u00b1\u00b3"+
		"\t\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5>\3\2\2\2\u00b6\u00b8\t\3\2\2\u00b7\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba@\3"+
		"\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c7\3\2\2\2\u00c0\u00c4\t\4"+
		"\2\2\u00c1\u00c3\t\3\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c0\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00d0\3\2\2\2\u00c9"+
		"\u00cb\t\4\2\2\u00ca\u00cc\t\3\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf"+
		"\u00bc\3\2\2\2\u00cf\u00c9\3\2\2\2\u00d0B\3\2\2\2\u00d1\u00d3\7\17\2\2"+
		"\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5"+
		"\7\f\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\"\2\2\u00d7D\3\2\2\2\u00d8"+
		"\u00d9\13\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b#\2\2\u00dbF\3\2\2\2"+
		"\f\2\u00af\u00b4\u00b9\u00be\u00c4\u00c7\u00cd\u00cf\u00d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}