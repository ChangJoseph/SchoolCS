#This is a LZW compressor that reads the '.txt' file and compresses it
import string
textFile = open("toCompress.txt","r")
writeLocation = "compressed.txt"
stringText = textFile.read()
textFile.close()
#stringText += ' '

bits = 8


ogDict = {}

#Initiates dictionary with: ascii characters as the ogDict key & its ascii value as the ogDict value
for x in range(0,128):
	ogDict[chr(x)] = x

dict = ogDict #protects base ascii

stringTextClone = stringText #Protects original text

#This while loop determines the best amount of bits
try:
	while (len(stringTextClone) > 1): #while this string still has stuff in it
		if (len(dict) > 2**bits): #if the dictionary length surpasses current bit size
			bits += 1
		i=2
		while (stringTextClone[0:i] in dict):
			i+=1
		if i > len(stringTextClone):
			stringTextClone = stringTextClone[i:]
		else:
			dict[len(dict)]=stringTextClone[0:i]
			stringTextClone = stringTextClone[i:]
except:
	print('error determining best bits; bits set to 10 as default')
	bits = 10


input('Best bits: ' + str(bits) + '\n')

if (input('Do you want to continue? (y/n)\n').upper() != 'Y'):
	quit()

finalBinary = '' #Final binary string this script should outputs

stringTextClone = stringText #Protects original text

dict = ogDict #protects base ascii

#This while loop will do the actual compressing
try:
	while (len(stringTextClone) > 1): #while this string still has stuff in it
		while (stringTextClone[0:i] in dict):
			i+=1
		component = ''
		if i > len(stringTextClone):
			component = stringTextClone[i:]
			dict[len(dict)]= component
			stringTextClone = component
		else:
			component = stringTextClone[0:i]
			dict[len(dict)]= component
			stringTextClone = stringTextClone[i:]
		finalBinary += bin(dict[component])[2:].rjust(bits,'0')
except:
	print('error compressing toCompress file\n')

log = open(writeLocation,'w')
log.write(finalBinary)
log.close()
input('Finished writing to ' + writeLocation +'\n')



