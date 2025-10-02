from collections import defaultdict

inventory = defaultdict(int)
inventory.update({"chair": 6, "desk": 2})
inventory["lamp"] = 9

print(inventory["chair"])
