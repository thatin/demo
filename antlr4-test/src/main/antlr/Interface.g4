grammar Interface;



// Parser Rules

runningConfig : INTERFACE ETHERNET portNumber ;

portNumber : TEXT;

// Lexer Rules

INTERFACE : 'interface';

ETHERNET : 'ethernet';

TEXT : ([0-9] | '/')+;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' | '!' )+ -> skip ;
