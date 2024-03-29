#!/bin/python3

import math
import os
import random
import re
import sys



import requests
#
# Complete the 'ipTracker' function below.
#
# URL for cut and paste
# https://jsonmock.hackerrank.com/api/ip?ip=<ip>
#
# The function is expected to return a STRING.
# The function accepts a singe parameter ip.
# In case of no ip record, return string 'No Result Found'
#

def ipTracker(ip):
    try:
        apiUrl = f"https://jsonmock.hackerrank.com/api/ip?ip={ip}"

        response = requests.get(apiUrl)

        if response.status_code == 200:
            jsonResponse = response.json()

            if jsonResponse["total"] == 0:
                return "No Result Found"
            else:
                country = jsonResponse["data"][0]["country"]
                return country
        else:
            # If request was unsuccessful, return error message
            return f"Error: Unable to fetch data - Status code: {response.status_code}"
    except Exception as e:
        # If an exception occurs, return error message
        print(e)
        return "Error: Unable to fetch data - Exception: {}".format(e)
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    
    ip = input()

    result = ipTracker(ip)

    fptr.write(str(result) + '\n')

    fptr.close()
