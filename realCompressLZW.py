textFile = open("longJoke.txt","r")
writeLocation = "testTXT.txt"
stringText = textFile.read()
textFile.close()
dict_size = 256
dict = {}
for x in range(0,128):
	dict[chr(x)] = x

w = ""
result = []
for c in stringText:
    wc = w + c
    if wc in dict:
        w = wc
    else:
        result.append(dict[w])
        dictionary[wc] = dict_size
        dict_size += 1
        w = c
	# Output the code for w.
	if w:
		result.append(dict[w])
print(result)
input('')