#This is a LZW compressor that reads the '.txt' file and compresses it
import string
textFile = open("longJoke.txt","r")
writeLocation = "compressed.txt"
stringText = textFile.read()
textFile.close()
#stringText += ' '

bits = 8


dict = {}

#Initiates dictionary with: ascii characters as the dict key & its ascii value as the dict value
for x in range(0,128):
	dict[chr(x)] = x

finalBinary = '' #Final binary string this script should outputs

stringTextClone = stringText #Protects original text

#This while loop determines the best amount of bits
try:
	while (len(stringTextClone) > 1): #while this string still has stuff in it
		if (len(dict) > 2^bits): #if the dictionary length surpasses current bit size
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
	print('error determining best bits')
	bits = 10


print(bits)
input('')




