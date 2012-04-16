#!/usr/bin/env python

import random

def main():
	archivo = open("Tp1Ej2_test.in", "w+")
	for x in range(100):
		# largo de la matriz, de n x n
		n = random.randint(1,30);
		m = random.randint(1,30);
		archivo.write("%i %i\n" % (n,m))
		for x in range (n*m):
			archivo.write("%i " % random.randint(1,15));
		archivo.write("\n")
	archivo.close()

main()
