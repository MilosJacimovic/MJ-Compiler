package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class MJParserTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTest.class);
		
		Reader br = null;
		try {
			File sourceCode = new File("test/test301_A.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
	        Tab.init();
	        
	        if(p.errorDetected == true)
		     {
		        log.error("Parsiranje NIJE uspesno zavrseno! Problem u sintaksnoj analizi!");
		     }
	        else
	        {
		        log.info(prog.toString(""));
				log.info("===================================");
	
				// ispis prepoznatih programskih konstrukcija
				SemanticAnalyzer sa = new SemanticAnalyzer();
				prog.traverseBottomUp(sa); 
				
				log.info("Sintaksna analiza uspesno zavrsena!");
				
				
				if(!sa.errorDetected && sa.passed()){
					log.info("Semanticka analiza uspesno zavrsena!");
					Tab.dump();
					
					File obFile = new File("test/program.obj");
					if(obFile.exists()) obFile.delete();
					
					CodeGenerator cd = new CodeGenerator();
					prog.traverseBottomUp(cd);
					Code.dataSize = sa.nVars;
					Code.mainPc = cd.getMainPc();
					Code.write(new FileOutputStream(obFile));
					log.info("Generisanje koda uspesno zavrseno!");
					
				}else{
					log.error("Parsiranje NIJE uspesno zavrseno! Problem u semantickoj analizi!");
				}
	        }
		
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
