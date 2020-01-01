package com.syntax;

import com.token;

/**
 * 
 * opt: type of operation, including  
 *      ShiftIn = 0
 *      Reduction = 1
 *      Accept = 2
 *      GOTO = 3
 * optObjIndex: the index of the operating object, correspondingly that
 *      Next state -> Shift in
 *      Index of expression -> Reduction
 *      None -> Accept
 *      Next state -> GOTO
 */
public class operate {
    public int begState;
    public int opt;
    public int optObjIndex;
    public token switcher;

    public operate(int begState, int opt, int optObjIndex, token switcher) {
        this.begState = begState;
        this.opt = opt;
        this.optObjIndex = optObjIndex;
        this.switcher = switcher;
    }
}