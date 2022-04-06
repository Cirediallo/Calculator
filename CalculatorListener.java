// Generated from Calculator.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculatorParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculatorParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CalculatorParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CalculatorParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#fonction}.
	 * @param ctx the parse tree
	 */
	void enterFonction(CalculatorParser.FonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#fonction}.
	 * @param ctx the parse tree
	 */
	void exitFonction(CalculatorParser.FonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CalculatorParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CalculatorParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CalculatorParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CalculatorParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculatorParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculatorParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CalculatorParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CalculatorParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(CalculatorParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(CalculatorParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#ifElseStat}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStat(CalculatorParser.IfElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#ifElseStat}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStat(CalculatorParser.IfElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(CalculatorParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(CalculatorParser.Logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CalculatorParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CalculatorParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CalculatorParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CalculatorParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalculatorParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalculatorParser.ExprContext ctx);
}