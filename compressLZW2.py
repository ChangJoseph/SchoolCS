#This is a LZW compressor that reads the '.txt' file and compresses it
import string
textFile = open("longJoke.txt","r")
writeLocation = "testTXT.txt"
stringText = textFile.read()
textFile.close()
#stringText += ' '

bits = 10


dict = {}

for x in range(0,128): #Initiates dictionary with: ascii characters as the dict key & its ascii value as the dict value
	dict[chr(x)] = x
finalBinary = '' #Final binary string it outputs

stringTextClone = stringText
while (len(stringTextClone) > 0): #This determines the best amount of bits
	if (len(dict) > 2^bits):
		bits += 1
	i=2
	while (stringTextClone[0:i] in dict):
		i+=1
	dict[len(dict)]=stringTextClone[0:i]
	stringTextClone = stringTextClone[i:]

try:
	stringTextClone = stringText
	for counter in range(0,len(stringText)-1):
		if (len(dict) > 2^bits):
		bits += 1
	i=2
	while (stringTextClone[0:i] in dict):
		i+=1
	dict[len(dict)]=stringTextClone[0:i]
	finalBinary += bin(dict[stringClone[0:i-1])[2:].rjust(bits,'0') #check this
	stringTextClone = stringTextClone[i:]
except:
	print('error in iterative process')

log = open(writeLocation,'w')
log.write(finalBinary)
log.close()
input('Finished writing to ' + writeLocation)



