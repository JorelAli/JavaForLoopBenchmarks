from tabulate import tabulate
import subprocess
from cpuinfo import get_cpu_info

tabulate.WIDE_CHARS_MODE = True
tabulate.PRESERVE_WHITESPACE = True

# Print the Java version
subprocess.run(['java', '-version'], stdout=subprocess.PIPE)
print()
print('Running on', get_cpu_info()['brand_raw'], '(%s) @ %s' % (get_cpu_info()['arch'], get_cpu_info()['hz_actual_friendly']))
print()

# Compile everything...
print('Compiling... ', end='', flush=True)
subprocess.run(['javac', '-cp', 'src/', '-d', 'bin/', 'src/*.java'], stdout=subprocess.PIPE, shell=True)
print("Done!")

tests = [
    'Test_AE',
    'Test_AEB',
    'Test_AEBF',
    'Test_AEF',
    'Test_AI',
    'Test_AIB',
    'Test_AIC',
    'Test_AICB',
    'Test_AICBF',
    'Test_AICBR',
    'Test_AICF',
    'Test_AICR',
    'Test_LE',
    'Test_LEB',
    'Test_LEBF',
    'Test_LEF',
    'Test_LI',
    'Test_LIB',
    'Test_LIC',
    'Test_LICR',
    'Test_LICB',
    'Test_LICBF',
    'Test_LICBR',
    'Test_LICF',
    'Test_one_liner',
    'Test_hash',
    'Test_linkedhash'
]

iterations = 10

results = []

actualFlags = ['A', 'L', 'I', 'E', 'C', 'B', 'F', 'R']


# Requires --add-opens runtime flag:
# https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m
# --add-opens has the following syntax: {A}/{package}={B}
# java --add-opens java.base/java.lang=ALL-UNNAMED

for test in tests:
    total = 0
    print('Running', iterations, 'iterations of test', test, '... ', end='', flush=True)
    for i in range(iterations):
        result = subprocess.run(['java', '-cp', 'bin/', test, 'A5000'], stdout=subprocess.PIPE, shell=True)
        total += int(result.stdout.decode('utf-8'))
    print('Done!')


    flags = ['🔴'] * len(actualFlags) # 8 flags possible, in the order: A, L, I, E, C, B, F, R

    for char in range(5, len(test)):
        for flagIndex in range(len(actualFlags)):
            if test[char] == actualFlags[flagIndex]:
                flags[flagIndex] = '🟢' #'✔️'

    results.append([test] + flags + [(total / iterations)])

print()
print("Printing lovely test results report...")
print()
print(tabulate(results, floatfmt=",", headers=["Test"] + actualFlags + ["Average time over " + str(iterations) + " iterations (ns)"], tablefmt="rounded_grid"))