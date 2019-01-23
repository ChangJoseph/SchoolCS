#This is a LZW decompressor that reads the 'binarycode.txt' file and decompresses it
import string
textFile = open("testTXT.txt","r") #Creates binary file from the TXT
stringText = textFile.read() #Initiates a string of the binary TXT file
textFile.close()
bits = int(input('How many bits?\n')) #User inputs amount of bits per 'ascii' value
if bits < 8: #Makes sure # of bits is valid
	print('invalid bits')
	quit()

list = [stringText[i:i+bits] for i in range(0, len(stringText), bits)] #Separates binary file into segments of %bits
dictionary = {}
for x in range(0,128): #This initiates the dictionary with 0-127 as the corresponding ascii values
	dictionary[x] = chr(x)
finalString = '' #This is the final print string

try:
	for counter in range(0,len(list)-1): #Loops through the decimal list until before the last element
		decimalX = int(list[counter],2) #Gets current decimal ascii
		decimalXNext = int(list[counter+1],2) #Gets next decimal ascii
		if decimalXNext not in dictionary: #Special case for immediate duplicate characters
			print(list[counter]+" "+str(decimalX)+"\t"+ dictionary[decimalX])
			dictionary[len(dictionary)] = dictionary[decimalX] + dictionary[decimalX][0:1] #Adds new key of next highest number (length) of duplicate characters
			finalString += dictionary[decimalX] #Adds current %decimalX dictionary value into the final print string
		else:
			print(list[counter]+" "+str(decimalX)+"\t"+ dictionary[decimalX])
			dictionary[len(dictionary)] = dictionary[decimalX] + dictionary[decimalXNext][0:1] #Adds new dict entry of current and next dict[decimal]
			finalString += dictionary[decimalX]
except:
	print('****Main Iteration Failed****')

try: #This is the last element iteration (AKA: Edge case)
	lastDecimal = int(list[len(list)-1], 2)
	print(list[counter]+" "+str(lastDecimal)+"\t"+ dictionary[lastDecimal])
	finalString += dictionary[lastDecimal]
except:
	print('****Edge Case Iteration Failed****')

log = open("log.txt",'w')
log.write(finalString) #Writing the final decompressed string`
log.close()
input('----Finished----')