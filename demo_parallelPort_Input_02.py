#!/usr/bin/env python
# -*- coding: utf-8 -*-
#this is win32 only - I have no idea how to use parallel ports on a Mac! jwp

# how to read out control data from parallel port
# demo TK
# 20160224 SL, TK, Anpassung für psychopy 1.8, Nutzung von inpout32.dll inpout32.sys(muss nachinstalliert werden)
# 

from psychopy import visual, core, event, parallel

# parallelport constants
baseAddress = 0x3010  #  0xC010  muss kontrolliert und angepasst werden (Gerätemanager), Standard ist 0x378

BASE_PORT = parallel.ParallelPort(address=baseAddress)
STAT_PORT = parallel.ParallelPort(address=baseAddress+1)
CTRL_PORT = parallel.ParallelPort(address=baseAddress+2)


# reset control-pins
CTRL_PORT.setData(0) 
# set DataLines to input - switch direction using controlAdress  (pin 5, 32, 0x20)
CTRL_PORT.setData( 0x20 )

print baseAddress
print STAT_PORT.readData()

ExpWin = visual.Window ( [ 800, 600 ]  )
InstructText = visual.TextStim ( ExpWin,        
                        pos= ( 0.0, 0.4 ) , 
                        text= u"LPT input: (escape: end)" 
                        )
                        
InputText = visual.TextStim ( ExpWin,        
                        pos= ( 0.0, 0.0 ) , 
                        text= ''
                        )                        

InstructText.draw()
ExpWin.flip()

# so wird der base port ausgelesen, nachdem er über CTRL_PORT auf input gesetzt wurde
dataLPTin = ~BASE_PORT.readData () & 255
print dataLPTin

while True:
    dataactual = ~BASE_PORT.readData () & 255
    if dataactual <> dataLPTin:
        dataLPTin = dataactual
        if dataLPTin > 0:
            print dataLPTin
            for i in range ( 6, -1, -1) :
                if dataLPTin // 2**i > 0:
                    LPTkey = i + 1
                    InputText.setText ( str ( LPTkey ) )
                    InstructText.draw()
                    InputText.draw()
                    ExpWin.flip()
                    break
        else:
            InstructText.draw()
            ExpWin.flip()

    for keys in event.getKeys():
        if keys in ['escape','q']:
                core.quit()
