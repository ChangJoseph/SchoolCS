#This is a LZW compressor that reads the '.txt' file and compresses it
import string
textFile = open("longJoke.txt","r")
writeLocation = "testTXT.txt"
stringText = textFile.read()
textFile.close()
#stringText += ' '

bits = int(input('How many bits?\n')) #User inputs amount of bits per 'ascii' value
if bits < 8: #Makes sure # of bits is valid
	print('invalid bits')
	quit()

dict = {}

for x in range(0,128): #Initiates dictionary with: ascii characters as the dict key & its ascii value as the dict value
	dict[chr(x)] = x
finalBinary = '' #Final binary string it outputs

try:
	for counter in range(0,len(stringText)-1):
		try:
			iteration = 2
			currentStr = stringText[counter]
			nextChar = stringText[counter+1]
		except:
			print('errors in declarations')
		while ( ('' + currentStr + nextChar) in dict and iteration+counter < len(stringText)): #Correct the +1 / -1
			currentStr = '' + currentStr + nextChar
			nextChar = stringText[counter+iteration]
			iteration += 1
		dict[''+currentStr+nextChar] = len(dict)
		finalBinary += bin(dict[currentStr])[2:].rjust(bits,'0')
except:
	print('error in iterative process')

log = open(writeLocation,'w')
log.write(finalBinary)
log.close()
input('Finished writing to ' + writeLocation)